//private boolean flag = true;									//用于标记前一个符号是否是')'，若是，则当前数字字符串一定为空
package algorithmTool.formula.caculator;

import java.util.Stack;

import algorithmTool.formula.exception.FormulaException;

/**
 * 计算器
 * @description 接收运算式，完成计算步骤并返回
 * 				<br>
 * @author BlazingPhoenix
 * @version 1.01
 */
public class Calculator {
	
	private int NP = 1;												//标记进栈数字元素的正负性
	private boolean NPCanUse = true;								//NP标记是否是激活状态
	private boolean flag = true;									//标记，当前正在读取的符号或上一个符号是否是运算符（两个有意义的运算符不能紧挨着）
	private FormulaException exception;								//异常
	private Stack<Float> figure = new Stack<Float>();				//数字栈
	private Stack<Character> operator = new Stack<Character>();		//符号栈
	private StringBuffer figureString = new StringBuffer();			//数字字符串，用于暂时存放读取到的单个数字字符，并将它们拼接成一个完整的数字
	
	/**
	 * @description 计算运算式（主程序）<br>
	 * 				根据传入的代表算式的字符串计算结果并返回<br>
	 * 				如果运算式存在问题，捕获异常并抛出
	 * @param formula 运算式
	 * @return 运算式的计算结果
	 * @throws FormulaException 抛出的异常
	 */
	public float calculate(String formula) throws FormulaException
	{
		try {
			return calculateImpl(formula);			//计算
		}
		catch (FormulaException e)
		{
			throw e;			//捕获运算式异常
		}
		catch (Exception e)		//捕获到异常，则抛出一个不明原因异常
		{
			exception = FormulaException.getUnKnowException();
			throw exception;
		}
	}
	
	/**
	 * @description 计算运算式（实现方法）<br>
	 * 				根据传入的代表算式的字符串计算结果并返回
	 * @param formula 代表算式的字符串
	 * @return 计算结果
	 */
	public float calculateImpl(String formula) throws FormulaException
	{
		formula += "#";				//结束符
		operator.push('#');			//起始符
		for (int i = 0;i < formula.length();i ++)
		{
			//读取到非运算符（非数字符号）时进行的操作
			if (!isOperator(formula.charAt(i)))
				doWhenCharIsNotOperator(formula.charAt(i));
			//读取到非运算符（数字符号）时进行的操作
			else
			{
				if (!doWhenCharIsOperator(formula.charAt(i),formula.charAt(i - 1 > -1 ? i -1 : 0)))
					throw exception;
			}
		}
		operator.pop();				//符号栈栈顶出栈
		if (operator.peek() == '(' || operator.peek() == ')')
		{
			exception = FormulaException.getBracketMismatchException();
			throw exception;
		}
		//字符串读取完成，但是符号栈内仍然有运算符
		else if (getPriority(operator.pop()) != -4)
		{
			exception = FormulaException.getUnKnowException();
			throw exception;
		}
		else
			return figure.pop();
	}
	
	
	/**
	 * @description 判断即将要进行的运算是否正确<br>
	 * 				检查是否是除数为0的除法运算或定义域不正确的次方运算
	 * @param c 运算符
	 * @param d 运算符右侧的数字
	 * @return
	 */
	public boolean operateIsRight(char c,float d)
	{
		if (c == '/' && d == 0)
		{
			exception = FormulaException.getDivideByZeroException();			//除零异常
			return false;
		}
		else if (c == '(' || c == ')')					//括号不匹配异常
		{
			exception = FormulaException.getBracketMismatchException();
			return false;
		}
		return true;
	}
	
	/**
	 * @description 当前读取到的字符不是运算符时进行的操作<br>
	 * 				说明读取到的字符是数字，将它接到数字字符串之后<br>
	 * 				由于下一个字符一定不会是正负号，所以激活标记睡眠
	 * 
	 * @param currentCharacter 当前读取到的字符
	 */
	private void doWhenCharIsNotOperator(char currentCharacter)
	{
		figureString.append(currentCharacter);
		flag = false;			//当前符号是数字
		NPCanUse = false;		//NP标记休眠
	}
	
	
	/**
	 * @description 当前读取到的字符是运算符时进行的操作<br>
	 * 				
	 * @param currentCharacter 当前读取到的字符
	 */
	private boolean doWhenCharIsOperator(char currentCharacter,char proCharacter)
	{
		//非（当前符号是加减号且正负号标记激活状态），即当前符号不是正负号
		if (!(getPriority(currentCharacter) == 1 && NPCanUse == true))
		{
			if (flag == true && currentCharacter != '(')		//运算符后不能紧跟除左括号外的运算符
			{
				exception = FormulaException.getCharacterException();
				return false;
			}
			//pushFigure尝试将数字字符串进栈数字栈（有些特殊情况不能进栈）
			//operate尝试运算（有些情况当前字符不会参与运算）
			if (!pushFigure(currentCharacter,proCharacter) || !operate(currentCharacter))			
				return false;
			if (currentCharacter != ')')		//除右括号外其他运算符右边均不能接乘除号
				flag = true;
		}
		//当前符号是正负号，并且为负号时，正负号标记*-1
		else
			NP *= currentCharacter == '-' ? -1: 1; 
		//当读取到的不是右括号，NP激活（右括号后不能紧跟正负号）
		if (getPriority(currentCharacter) != -3) // == 1 || getPriority(currentCharacter) == 3)
			NPCanUse = true;
		return true;
	}
	
	
	
	/**
	 * @description 数字栈进栈
	 * 				<br>
	 * 				根据当前符号判断是否将数字符号串内的内容转为数字并进栈数字栈
	 * 				<br>
	 * 				并重置NP标记，并将其改为休眠状态
	 * 				<br>
	 * @param currentCharacter 当前读取的符号
	 * @param proCharacter 当前读取的符号的上一个符号
	 */
	private boolean pushFigure(char currentCharacter,char proCharacter)
	{
		//若当前符号不是左括号且前一个符号不是右括号，数字栈进栈并将数字字符串清空。否则当前数字字符串内应该是没有内容的
		//若当前符号是左括号，说明之前的不是数字，那在之前数字字符串就被清空过；前一个符号是右括号时同理
		if (currentCharacter != '(' && proCharacter != ')')
		{
			try {
				figure.push(Float.valueOf(figureString.toString()) * NP);		//将数字字符串的内容转为数字并进栈数字栈
			}catch (Exception e){
				exception = FormulaException.getFigureException();			//数字异常
				return false;
			}
			figureString.setLength(0);										//清空数字字符串
			NP = 1;					//重置NP及其激活状态
			NPCanUse = false;		//NP休眠
		}	
		//System.out.println(currentCharacter);
		if (currentCharacter == '(' && proCharacter == ')')
		{
			doWhenCharIsOperator('*',')');
		}
		return true;
	}
	
	
	
	/**
	 * @description 运算操作
	 * 				<br>
	 * 				根据当前符号的意义判断是否进行运算，如果是则进行运算
	 * 				<br>
	 * 				如果当前符号暂时不能参与运算，根据当前符号做相应的处理
	 * 				<br>
	 * @param currentCharacter 当前读取的符号
	 */
	private boolean operate(char currentCharacter)
	{
		//尝试将当前符号拿来参与运算
		while((getPriority(currentCharacter) <= getPriority(operator.peek())) && operator.peek() != '(' && operator.peek() != '#')
		{
			float d = figure.pop();
			if (!operateIsRight(operator.peek(),d))		//判断将要进行的运算是否会出现异常
				return false;			//出现异常
			float u = figure.pop();
			figure.push(operate(operator.pop(),u,d));
		}
		if (getPriority(currentCharacter) < getPriority(operator.peek()) && getPriority(currentCharacter) + getPriority(operator.peek()) == 0)
		{
			operator.pop();							//去括号
		}
		else
			operator.push(currentCharacter);		//当前符号优先级太低没参与运算，且不是右括号，进栈符号栈
		return true;
	}
	

	//判断符号c是否为运算符，若是则返回true
	private boolean isOperator(char c)
	{
		return getPriority(c) != -5;
	}

	//获取字符c的优先级并返回
	private int getPriority(char c)
	{
		switch(c)
		{
			case '+':return 1;
			case '-':return 1;
			case '*':return 2;
			case '/':return 2;
			case '(':return 3;
			case ')':return -3;
			case '#':return -4;			//结束或起始符号
			default:return -5;
		}
	}

	/**
	 * @description 计算
	 * 				<br>
	 * 				根据运算符和两个数字计算结果
	 * @param c 运算符
	 * @param u 运算符左边的数字
	 * @param d 运算符右边的数字
	 * @return 计算结果
	 */
	private float operate(char c,float u,float d)
	{
		switch(c)
		{
			case '+':return u + d;
			case '-':return u - d;
			case '*':return u * d;
			case '/':return u / d;
			default:return 0;
		}
	}
	
}

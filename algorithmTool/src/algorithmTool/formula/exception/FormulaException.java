package algorithmTool.formula.exception;

/**
 * 运算式异常类
 * @description 提供几个含有不同的运算式异常信息的异常对象
 * @author BlazingPhoenix
 *
 */
public class FormulaException extends Exception {

	//除零异常
	private static FormulaException divideByZeroException = new FormulaException("除零异常：算式中某个除法运算的除数为0，请检查！");
	//定义域异常
	private static FormulaException definitionDomainException = new FormulaException("定义域越界：请检查根号或次方运算等是否正确！");
	//运算符异常，某个运算符后紧接着乘除号或运算式开头为乘除号
	private static FormulaException characterException = new FormulaException("运算符使用错误，请检查！");
	//运算式中存在无法识别的符号，或数字中存在多个小数点，最终导致数字字符串无法转化为数字
	private static FormulaException figureException = new FormulaException("运算式错误：存在无法识别的符号！");
	//左右括号不匹配
	private static FormulaException bracketMismatchException = new FormulaException("左右括号不匹配，请检查！"); 
	//不明原因的异常，最可能是因为左右括号不匹配
	private static FormulaException unKnowException = new FormulaException("运算式不明错误：可能是左右括号不匹配！");
	
	/*无参构造函数*/
	private FormulaException(){
		super();
	}   
	
	//用详细信息指定一个异常
	private FormulaException(String message){
		super(message);
	}
	    
	
	//用指定的详细信息和原因构造一个新的异常
	private FormulaException(String message, Throwable cause){
		super(message,cause);
	}
	    
	//用指定原因构造一个新的异常
	private FormulaException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 除零异常
	 * @return 带有除零异常提示信息的对象
	 */
	public static FormulaException getDivideByZeroException()
	{
		return divideByZeroException;
	}
	    
	/**
	 * 定义域异常
	 * @return 带有定义域异常提示信息的对象
	 */
	public static FormulaException getDefinitionDomainException()
	{
		return definitionDomainException;
	}
	
	/**
	 * 运算符异常
	 * @return 带有运算符使用错误信息的对象
	 */
	public static FormulaException getCharacterException()
	{
		return characterException;
	}
	
	/**
	 * 数字异常
	 * @return 带有引发该异常原因的提示信息的对象
	 */
	public static FormulaException getFigureException()
	{
		return figureException;
	}
	
	/**
	 * 不明异常
	 * @return 带有异常提示信息的对象
	 */
	public static FormulaException getUnKnowException()
	{
		return unKnowException;
	}
	
	/**
	 * 括号匹配异常
	 * @return 带有括号匹配错误信息的对象
	 */
	public static FormulaException getBracketMismatchException()
	{
		return bracketMismatchException;
	}
	
}

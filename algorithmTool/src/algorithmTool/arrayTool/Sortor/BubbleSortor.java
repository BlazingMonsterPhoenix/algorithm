package algorithmTool.arrayTool.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTool.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;

/**
 * 冒泡排序类
 * @author FieryPhoenix
 * 
 */
public class BubbleSortor extends AbstractSortor {
	
	/**
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public BubbleSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public BubbleSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public BubbleSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public BubbleSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public BubbleSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public BubbleSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public BubbleSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public BubbleSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public BubbleSortor(boolean[] array)
	{
		super(array);
	}

	/**
	 * 冒泡排序实现方法
	 */
	@Override
	protected Object[] sort(int start, int end) {
		for (int j = end; j > start; j --)
		{
			for (int i = start; i < j; i ++)
			{
				if (MathTool.leftOneIsBigger(array[i], array[i + 1]))
					exchange(i, i + 1);
			}
		}
		return array;
	}

}

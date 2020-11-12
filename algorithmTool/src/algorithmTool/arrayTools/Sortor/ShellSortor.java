package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;

/**
 * 希尔排序类
 * @author BlazingPhoenix
 * 
 */
public class ShellSortor extends AbstractSortor{
	
	/**
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public ShellSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public ShellSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public ShellSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public ShellSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public ShellSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public ShellSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public ShellSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public ShellSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public ShellSortor(boolean[] array)
	{
		super(array);
	}

	/**
	 * Byte构造方法
	 * @param array 准备进行排序的Byte数组
	 */
	public ShellSortor(Byte[] array)
	{
		super(array);
	}
	
	/**
	 * Short构造方法
	 * @param array 准备进行排序的Short数组
	 */
	public ShellSortor(Short[] array)
	{
		super(array);
	}
	
	/**
	 * Integer构造方法
	 * @param array 准备进行排序的Integer数组
	 */
	public ShellSortor(Integer[] array)
	{
		super(array);
	}
	
	/**
	 * Long构造方法
	 * @param array 准备进行排序的Long数组
	 */
	public ShellSortor(Long[] array)
	{
		super(array);
	}
	
	
	/**
	 * Float构造方法
	 * @param array 准备进行排序的Float数组
	 */
	public ShellSortor(Float[] array)
	{
		super(array);
	}
	
	/**
	 * Double构造方法
	 * @param array 准备进行排序的Double数组
	 */
	public ShellSortor(Double[] array)
	{
		super(array);
	}
	
	/**
	 * Character构造方法
	 * @param array 准备进行排序的Character数组
	 */
	public ShellSortor(Character[] array)
	{
		super(array);
	}
	
	/**
	 * Boolean构造方法
	 * @param array 准备进行排序的Boolean数组
	 */
	public ShellSortor(Boolean[] array)
	{
		super(array);
	}
	
	@Override
	protected Object[] sort(int start, int end) {
		shellSort(start, end, end - start + 1);
		return array;
	}
	
	/**
	 * 希尔排序
	 * @param start 排序部分第一个元素下标
	 * @param end 排序不分最后元素下标
	 * @param num 每组的元素数
	 */
	private void shellSort(int start, int end, int num)
	{
		int step = (end - start + 1) / num;		//同一组的两个相邻元素的下标差
		if (num > 3)
			shellSort(start, end, num / 2);
		for (int i = 0; i < step; i ++)			//循环，对每组进行插入排序
			shellInsert(start + i, end, step);
	}
	
	/**
	 * 希尔排序，分组插入排序
	 * @param start 起始元素下标
	 * @param end 最后一个元素下标
	 * @param step 当前组的两个相邻元素的下标差
	 */
	private void shellInsert(int start, int end, int step)
	{
		for (int j = start + step; j <= end; j += step)			//左边第二个元素插入到第一个元素前或后，然后第三个元素插入到前两个元素组成的数组中，以此类推（从左向右插入）
		{
			Object flag = array[j];			//等待插入的元素		
			for (int i = j - step; i >= start - step; i -= step)
			{
				//待插入元素比左边所有元素小，或待插入元素的值大于左侧元素（array[i]）的值，该元素放在array[i]右边
				if (i == start - step || MathTool.leftOneIsBigger(flag, array[i]))
				{
					array[i + step] = flag;
					break;
				}
				else		//待插入元素的值比左侧元素小，左侧元素右移
					array[i + step] = array[i];
			}
		}
	}
}

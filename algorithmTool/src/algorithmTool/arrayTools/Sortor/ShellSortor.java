package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;

/**
 * 希尔排序累
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

	@Override
	protected Object[] sort(int start, int end) {
		return array;
	}
	
	/**
	 * 分组插入排序
	 * @param start 排序部分第一个元素下标
	 * @param end 排序不分最后元素下标
	 * @param part 分组数
	 */
	private void insert(int start, int end, int part)
	{
		for (int i = start; i < end; i += (end - start + 1) / 2)
		{
			
		}
	}
}

package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;
/**
 * 归并排序类
 * @author FieryPhoenix
 *
 */
public class MergeSortor extends AbstractSortor {
	
	/**
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public MergeSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public MergeSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public MergeSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public MergeSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public MergeSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public MergeSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public MergeSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public MergeSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public MergeSortor(boolean[] array)
	{
		super(array);
	}
	
	
	@Override
	protected Object[] sort(int start, int end) {
		int centre = (start + end) / 2;
		if (end - start > 1)
		{
			sort(start, centre);
			sort(centre + 1, end);
		}
		merge(start, centre, end);
		return array;
	}
	
	/**
	 * 归并
	 * @description 数组array，它的start下标的元素和end下标的元素间的部分成为数组a<br>
	 * 				数组a需要执行归并操作<br>
	 * 				该数组的左半部分和右半部分均从小到大排序<br>
	 * 				方法执行完后数组a从小到大排序
	 * @param array 数组array
	 * @param start 归并部分的起始元素下标
	 * @param centre 数组a左半部分最后一个元素的下标((start+end)/2)
	 * @param end 归并部分的最后一个元素的下标
	 */
	private void merge(int start, int centre, int end)
	{
		Object newArray[] = new Object[end - start + 1];
		int leftFlag = start;
		int rightFlag = centre + 1;
		for (int i = 0; i < newArray.length; i ++)
		{
			if (rightFlag > end || (leftFlag < centre + 1 && MathTool.leftOneIsBigger(array[rightFlag], array[leftFlag])))
			{
				newArray[i] = array[leftFlag];
				leftFlag ++;
			}
			else
			{
				newArray[i] = array[rightFlag];
				rightFlag ++;
			}
		}
		for (int i = 0; i < newArray.length; i ++)
			array[start + i] = newArray[i];
	}
	
}

package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;
/**
 * 归并排序类
 * @author BlazingPhoenix
 *
 */
public class MergeSortor extends AbstractSortor {
	
	/**
	 * 归并排序实现方法
	 */
	@Override
	protected Object[] sort(Object[] array, int start, int end) {
		int centre = (start + end) / 2;
		if (end - start > 1)
		{
			sort(array, start, centre);
			sort(array, centre + 1, end);
		}
		merge(array, start, centre, end);
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
	private void merge(Object[] array, int start, int centre, int end)
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

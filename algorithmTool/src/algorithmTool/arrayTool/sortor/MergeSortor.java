package algorithmTool.arrayTool.sortor;

import algorithmTool.arrayTool.abstractSortor.AbstractSortor;
/**
 * 归并排序类
 * @author FieryPhoenix
 *
 */
public class MergeSortor extends AbstractSortor {
	
	@Override
	public int[] sort(int[] array, int start, int end) {
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
	private void merge(int[] array, int start, int centre, int end)
	{
		int newArray[] = new int[end - start + 1];
		int leftFlag = start;
		int rightFlag = centre + 1;
		for (int i = 0; i < newArray.length; i ++)
		{
			if (rightFlag > end || (leftFlag < centre + 1 && array[leftFlag] < array[rightFlag]))
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

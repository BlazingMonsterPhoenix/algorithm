package algorithmTool.arrayTool.intSortor;
/**
 * 整型数组排序工具类
 * @author BlazingPhoenix
 * @classDescription 提供不同方法对一个整数数组进行从小到大排序<br>
 * 				               将排序后的结果放在一个新数组中并返回<br>
 * 					   排序结果不影响传入的数组
 */
public class IntSortTool {
	
	/**
	 * 冒泡排序
	 * @description 排序比较次数比较固定，效率较低
	 * @param array 进行排序的数组
	 * @return 排序后的新数组
	 */
	public int[] bubbleSort(int[] array)
	{
		return new IntBubbleSortor().sort(array);
	}
	
	/**
	 * 插入排序
	 * @description 适用于较小的或相对较有序的数组
	 * @param array 进行排序的数组
	 * @return 排序后的新数组
	 */
	public int[] insertSort(int[] array)
	{
		return new IntInsertSortor().sort(array);
	}
	
	/**
	 * 归并排序
	 * @description 
	 * @param array 进行排序的数组
	 * @return 排序后的新数组
	 */
	public int[] mergeSort(int[] array)
	{
		return new IntMergeSortor().sort(array);
	}
	
	/**
	 * 快速排序
	 * @description 有时候也不是很快，快不快比较随缘
	 * @param array 进行排序的数组
	 * @return 排序后的新数组
	 */
	public int[] quickSort(int[] array)
	{
		return new IntQuickSortor().sort(array);
	}
	
	/**
	 * 选择排序
	 * @param array 进行排序的数组
	 * @return 排序后的新数组
	 */
	public int[] selectSort(int[] array)
	{
		return new IntSelectSortor().sort(array);
	}
}

package algorithmTool.arrayTools.searcher;

import algorithmTool.math.mathTools.MathTool;

/**
 * 整数数组元素搜索
 * @author BlazingPhoenix
 *
 */
public class ArrayElementSearcher {
	
	/**
	 * 二分查找法外部调用方法
	 * @param array 查询的数组
	 * @param key 查询的元素
	 * @return 若array中存在key，返回key的下标，否则返回-1
	 */
	public static int dichotomySearch(Object[] array, Object key)
	{
		return dichotomySearch(array,key,0,array.length - 1);
	}
	
	/**
	 * 二分查找法实现方法
	 * @description 在从小到大顺序排列的数组array中，查找元素key<br>
	 * 				如果存在这个元素，则返回其下标<br>
	 * 				如果不存在，则返回-1
	 * @param array 查询的数组
	 * @param key 查询的元素
	 * @param left 查询范围的最左侧元素下标
	 * @param right 查询范围的最右侧元素下标
	 * @return 元素的下标（如果数组中不存在查询的元素，返回-1）
	 */
	private static int dichotomySearch(Object[] array, Object key, int left, int right)
	{
		int centre = (left + right) / 2;
		if (array[centre] == key)
			return centre;
		else if (centre != left)
			return MathTool.leftOneIsBigger(array[centre], key) ? 
					dichotomySearch(array,key,left,centre) : dichotomySearch(array,key,centre,right);
		return -1;
	}
	
	/**
	 * 蛮力法查找
	 * @param array 查询的数组
	 * @param key 查询的元素
	 * @return 若array中存在key，返回key的下标，否则返回-1
	 */
	public static int search(Object[] array, Object key)
	{
		int i = array.length - 1;
		for (; i >= -1; i --)
		{
			if (i == -1 || array[i] == key)
				break;
		}
		return i;
	}
}

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
	
	

	@Override
	protected Object[] sort(Object[] array, int start, int end) {
		shellSort(array, start, end, end - start + 1);
		return array;
	}
	
	/**
	 * 希尔排序
	 * @param start 排序部分第一个元素下标
	 * @param end 排序不分最后元素下标
	 * @param num 每组的元素数
	 */
	private void shellSort(Object[] array, int start, int end, int num)
	{
		int step = (end - start + 1) / num;		//同一组的两个相邻元素的下标差
		if (num > 3)
			shellSort(array, start, end, num / 2);
		for (int i = 0; i < step; i ++)			//循环，对每组进行插入排序
			shellInsert(array, start + i, end, step);
	}
	
	/**
	 * 希尔排序，分组插入排序
	 * @param start 起始元素下标
	 * @param end 最后一个元素下标
	 * @param step 当前组的两个相邻元素的下标差
	 */
	private void shellInsert(Object[] array, int start, int end, int step)
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

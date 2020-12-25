package algorithmTool.arrayTools.sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;

/**
 * 冒泡排序类
 * @author BlazingPhoenix
 * 
 */
public class BubbleSortor extends AbstractSortor {
	
	/**
	 * 冒泡排序实现方法
	 * @description 使用冒泡排序对数组array的一部分进行排序<br>
	 * 				这不分的第一个元素下标为start，最后一个元素下标为end
	 * @param array 进行排序的数组
	 * @param start 进行排序部分的第一个元素的下标
	 * @param end 进行排序部分的最后一个元素的下标
	 */
	@Override
	protected Object[] sort(Object[] array, int start, int end) {
		for (int j = end; j > start; j --)
		{
			for (int i = start; i < j; i ++)
			{
				if (MathTool.leftOneIsBigger(array[i], array[i + 1]))
					exchange(array, i, i + 1);
			}
		}
		return array;
	}

}

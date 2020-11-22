package algorithmTool.arrayTools.Sortor;

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

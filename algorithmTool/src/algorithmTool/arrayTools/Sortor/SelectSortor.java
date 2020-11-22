package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;

/**
 * 选择排序类
 * @author BlazingPhoenix
 *
 */
public class SelectSortor extends AbstractSortor {

	/**
	 * 选择排序实现方法
	 */
	@Override
	protected Object[] sort(Object[] array, int start, int end) {
		for (int j = start; j < end; j++)
		{
			int flag = j;
			for (int i = j; i < end; i ++)
			{
				if (MathTool.leftOneIsBigger(array[flag], array[i + 1]))
					flag = i + 1;
			}
			exchange(array, j, flag);
		}
		return array;
	}

}

package algorithmTool.arrayTools.sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;
/**
 * 插入排序类
 * @author BlazingPhoenix
 *
 */
public class InsertSortor extends AbstractSortor {

	/**
	 * 插入排序实现方法
	 */
	@Override
	protected Object[] sort(Object[] array, int start, int end) {
		for (int j = start + 1; j <= end; j ++)
		{
			Object flag = array[j];
			for (int i = j - 1; i >= start - 1; i --)
			{
				if (i < start || MathTool.leftOneIsBigger(flag, array[i]))
				{
					array[i + 1] = flag;
					break;
				}
				else
					array[i + 1] = array[i];
			}
		}
		return array;
	}

}

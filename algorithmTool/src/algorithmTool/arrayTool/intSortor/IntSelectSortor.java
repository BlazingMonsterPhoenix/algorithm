package algorithmTool.arrayTool.intSortor;

import algorithmTool.arrayTool.abstractSortor.AbstractIntSortor;
/**
 * 选择排序类
 * @author FieryPhoenix
 *
 */
public class IntSelectSortor extends AbstractIntSortor {

	@Override
	protected int[] sort(int[] array, int start, int end) {
		for (int j = start; j < end; j++)
		{
			int flag = j;
			for (int i = j; i < end; i ++)
			{
				if (array[flag] > array[i + 1])
					flag = i + 1;
			}
			exchange(array, j, flag);
		}
		return array;
	}

}

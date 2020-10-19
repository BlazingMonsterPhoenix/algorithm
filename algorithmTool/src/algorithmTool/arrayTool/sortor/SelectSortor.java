package algorithmTool.arrayTool.sortor;

import algorithmTool.arrayTool.abstractSortor.AbstractSortor;
/**
 * 选择排序类
 * @author FieryPhoenix
 *
 */
public class SelectSortor extends AbstractSortor {

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

package algorithmTool.arrayTool.intSortor;

import algorithmTool.arrayTool.abstractSortor.AbstractIntSortor;

/**
 * 冒泡排序类
 * @author FieryPhoenix
 * 
 */
public class IntBubbleSortor extends AbstractIntSortor {

	@Override
	protected int[] sort(int[] array, int start, int end) {
		for (int j = end; j > start; j --)
		{
			for (int i = start; i < j; i ++)
			{
				if (array[i] > array[i + 1])
					exchange(array, i, i + 1);
			}
		}
		return array;
	}

}

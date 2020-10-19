package algorithmTool.arrayTool.sortor;

import algorithmTool.arrayTool.abstractSortor.AbstractSortor;

/**
 * 冒泡排序类
 * @author FieryPhoenix
 * 
 */
public class BubbleSortor extends AbstractSortor {

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

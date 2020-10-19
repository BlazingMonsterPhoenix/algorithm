package algorithmTool.arrayTool.sortor;

import algorithmTool.arrayTool.abstractSortor.AbstractSortor;
/**
 * 插入排序类
 * @author FieryPhoenix
 *
 */
public class InsertSortor extends AbstractSortor {

	@Override
	protected int[] sort(int[] array, int start, int end) {
		for (int j = start + 1; j <= end; j ++)
		{
			int flag = array[j];
			for (int i = j - 1; i >= start - 1; i --)
			{
				if (i < start || array[i] < flag)
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

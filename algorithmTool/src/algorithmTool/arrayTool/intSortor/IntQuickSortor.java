package algorithmTool.arrayTool.intSortor;

import algorithmTool.arrayTool.abstractSortor.AbstractIntSortor;

public class IntQuickSortor extends AbstractIntSortor {
	
	@Override
	protected int[] sort(int[] array, int start, int end) {
		if (end - start <= 0)
			return new int[0];
		int flag = array[start];			//以第一个元素作为基准元素（比它小的放左边，大的放右边）
		int left = start;					//左侧标记（标记的元素左侧的元素是比基准元素小的元素）
		int right = end;					//右侧标记（标记的元素及其右侧的元素是比基准匀速大的元素）
		for (int i = start + 1; i <= right; i ++)
		{
			if (array[i] < flag)			//当前比较元素比基准元素小
			{
				exchange(array,left,i);
				left ++;
			}
			else							//当前比较元素比基准元素大
			{
				exchange(array,right,i);
				right --;
				i --;					//由于exchange方法将一个未经过比较的元素移过来了，所以i要减一
			}
		}
		array[left] = flag;				//左侧标记标记的元素改为基准元素
		sort(array,start,left - 1);
		sort(array,left + 1,end);
		return array;
	}
}

package algorithmTool.arrayTools.Sortor;

import java.math.BigDecimal;

import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.math.mathTools.MathTool;
/**
 * 快速排序类
 * @author BlazingPhoenix
 *
 */
public class QuickSortor extends AbstractSortor {
	
	/**
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public QuickSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public QuickSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public QuickSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public QuickSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public QuickSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public QuickSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public QuickSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public QuickSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public QuickSortor(boolean[] array)
	{
		super(array);
	}
	
	@Override
	protected Object[] sort(int start, int end) {
		if (end - start <= 0)
			return new Object[0];
		Object flag = array[start];			//以第一个元素作为基准元素（比它小的放左边，大的放右边）
		int left = start;					//左侧标记（标记的元素左侧的元素是比基准元素小的元素）
		int right = end;					//右侧标记（标记的元素及其右侧的元素是比基准匀速大的元素）
		for (int i = start + 1; i <= right; i ++)
		{
			if (MathTool.leftOneIsBigger(flag, array[i]))			//当前比较元素比基准元素小
			{
				exchange(left,i);
				left ++;
			}
			else							//当前比较元素比基准元素大
			{
				exchange(right,i);
				right --;
				i --;					//由于exchange方法将一个未经过比较的元素移过来了，所以i要减一
			}
		}
		array[left] = flag;				//左侧标记标记的元素改为基准元素
		sort(start,left - 1);
		sort(left + 1,end);
		return array;
	}
}

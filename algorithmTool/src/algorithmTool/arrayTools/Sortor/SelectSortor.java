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
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public SelectSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public SelectSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public SelectSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public SelectSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public SelectSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public SelectSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public SelectSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public SelectSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public SelectSortor(boolean[] array)
	{
		super(array);
	}
	
	/**
	 * Byte构造方法
	 * @param array 准备进行排序的Byte数组
	 */
	public SelectSortor(Byte[] array)
	{
		super(array);
	}
	
	/**
	 * Short构造方法
	 * @param array 准备进行排序的Short数组
	 */
	public SelectSortor(Short[] array)
	{
		super(array);
	}
	
	/**
	 * Integer构造方法
	 * @param array 准备进行排序的Integer数组
	 */
	public SelectSortor(Integer[] array)
	{
		super(array);
	}
	
	/**
	 * Long构造方法
	 * @param array 准备进行排序的Long数组
	 */
	public SelectSortor(Long[] array)
	{
		super(array);
	}
	
	
	/**
	 * Float构造方法
	 * @param array 准备进行排序的Float数组
	 */
	public SelectSortor(Float[] array)
	{
		super(array);
	}
	
	/**
	 * Double构造方法
	 * @param array 准备进行排序的Double数组
	 */
	public SelectSortor(Double[] array)
	{
		super(array);
	}
	
	/**
	 * Character构造方法
	 * @param array 准备进行排序的Character数组
	 */
	public SelectSortor(Character[] array)
	{
		super(array);
	}
	
	/**
	 * Boolean构造方法
	 * @param array 准备进行排序的Boolean数组
	 */
	public SelectSortor(Boolean[] array)
	{
		super(array);
	}
	
	@Override
	protected Object[] sort(int start, int end) {
		for (int j = start; j < end; j++)
		{
			int flag = j;
			for (int i = j; i < end; i ++)
			{
				if (MathTool.leftOneIsBigger(array[flag], array[i + 1]))
					flag = i + 1;
			}
			exchange(j, flag);
		}
		return array;
	}

}

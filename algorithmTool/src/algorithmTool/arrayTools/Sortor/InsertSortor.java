package algorithmTool.arrayTools.Sortor;

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
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public InsertSortor(BigDecimal[] array) {
		super(array);
	}
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特型数组
	 */
	public InsertSortor(byte[] array)
	{
		super(array);
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public InsertSortor(short[] array)
	{
		super(array);
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public InsertSortor(int[] array)
	{
		super(array);
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public InsertSortor(long[] array)
	{
		super(array);
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public InsertSortor(float[] array)
	{
		super(array);
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public InsertSortor(double[] array)
	{
		super(array);
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public InsertSortor(char[] array)
	{
		super(array);
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public InsertSortor(boolean[] array)
	{
		super(array);
	}
	
	/**
	 * Byte构造方法
	 * @param array 准备进行排序的Byte数组
	 */
	public InsertSortor(Byte[] array)
	{
		super(array);
	}
	
	/**
	 * Short构造方法
	 * @param array 准备进行排序的Short数组
	 */
	public InsertSortor(Short[] array)
	{
		super(array);
	}
	
	/**
	 * Integer构造方法
	 * @param array 准备进行排序的Integer数组
	 */
	public InsertSortor(Integer[] array)
	{
		super(array);
	}
	
	/**
	 * Long构造方法
	 * @param array 准备进行排序的Long数组
	 */
	public InsertSortor(Long[] array)
	{
		super(array);
	}
	
	
	/**
	 * Float构造方法
	 * @param array 准备进行排序的Float数组
	 */
	public InsertSortor(Float[] array)
	{
		super(array);
	}
	
	/**
	 * Double构造方法
	 * @param array 准备进行排序的Double数组
	 */
	public InsertSortor(Double[] array)
	{
		super(array);
	}
	
	/**
	 * Character构造方法
	 * @param array 准备进行排序的Character数组
	 */
	public InsertSortor(Character[] array)
	{
		super(array);
	}
	
	/**
	 * Boolean构造方法
	 * @param array 准备进行排序的Boolean数组
	 */
	public InsertSortor(Boolean[] array)
	{
		super(array);
	}
	
	/**
	 * 插入排序实现方法
	 */
	@Override
	protected Object[] sort(int start, int end) {
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

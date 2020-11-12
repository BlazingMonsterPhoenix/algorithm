package algorithmTool.arrayTools.abstractSortor;

import java.math.BigDecimal;
/**
 * 抽象排序类
 * @author BlazingPhoenix
 * @classDescription 通过构造方法（重载）接收不同类型的数组<br>
 * 					   提供一个排序方法“sort()”供外部调用<br>
 * 				 	   部分排序方法作为排序的实现方法，供子类实现
 */
public abstract class AbstractSortor {
	
	protected Object array[];
	
	/**
	 * 比特型构造方法
	 * @param array 准备进行排序的比特数组
	 */
	public AbstractSortor(byte[] array)
	{
		this.array = new Byte[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 短整型构造方法
	 * @param array 准备进行排序的短整型数组
	 */
	public AbstractSortor(short[] array)
	{
		this.array = new Short[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 整型构造方法
	 * @param array 准备进行排序的整型数据
	 */
	public AbstractSortor(int[] array)
	{
		this.array = new Integer[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 长整型构造方法
	 * @param array 准备进行排序的长整型数组
	 */
	public AbstractSortor(long[] array)
	{
		this.array = new Long[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 浮点型构造方法
	 * @param array 准备进行排序的浮点型数组
	 */
	public AbstractSortor(float[] array)
	{
		this.array = new Float[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 双精度浮点型构造方法
	 * @param array 准备进行排序的双精度浮点型数组
	 */
	public AbstractSortor(double[] array)
	{
		this.array = new Double[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 字符型构造方法
	 * @param array 准备进行排序的字符型数组
	 */
	public AbstractSortor(char[] array)
	{
		this.array = new Character[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * 布尔型构造方法
	 * @param array 准备进行排序的布尔型数组
	 */
	public AbstractSortor(boolean[] array)
	{
		this.array = new Boolean[array.length];
		for (int i = 0; i < array.length; i ++)
			this.array[i] = array[i];
	}
	
	/**
	 * BigDecimal构造方法
	 * @param array 准备进行排序的BigDecimal数组
	 */
	public AbstractSortor(BigDecimal[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Byte构造方法
	 * @param array 准备进行排序的Byte数组
	 */
	public AbstractSortor(Byte[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Short构造方法
	 * @param array 准备进行排序的Short数组
	 */
	public AbstractSortor(Short[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Integer构造方法
	 * @param array 准备进行排序的Integer数组
	 */
	public AbstractSortor(Integer[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Long构造方法
	 * @param array 准备进行排序的Long数组
	 */
	public AbstractSortor(Long[] array)
	{
		this.array = array.clone();
	}
	
	
	/**
	 * Float构造方法
	 * @param array 准备进行排序的Float数组
	 */
	public AbstractSortor(Float[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Double构造方法
	 * @param array 准备进行排序的Double数组
	 */
	public AbstractSortor(Double[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Character构造方法
	 * @param array 准备进行排序的Character数组
	 */
	public AbstractSortor(Character[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * Boolean构造方法
	 * @param array 准备进行排序的Boolean数组
	 */
	public AbstractSortor(Boolean[] array)
	{
		this.array = array.clone();
	}
	
	/**
	 * 元素交换
	 * @description 将数组的两个元素进行交换
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	protected void exchange(int index1, int index2)
	{
		Object item = array[index1];
		array[index1] = array[index2];
		array[index2] = item;
	}
	
	/**
	 * 获取排序时间
	 * @deprecated
	 * @description 对一个整数数组进行从小到大排序，输出排序所用的时间<br>
	 * 				主要用于测试
	 * @param array 进行排序的数组
	 */
	public void getSortTime()
	{
		long startTime = System.currentTimeMillis();
		sort(0, array.length - 1);
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - startTime) + "毫秒");
	}
	
	/**
	 * 排序方法
	 * @description 对一个整数数组进行从小到大排序<br>
	 * 				将排序后的结果放在一个新数组中并返回
	 * @param array 进行排序的数组
	 * @return 排序后的数组
	 */
	public Object[] sort()
	{
		return sort(0, array.length - 1);
	}
	
	/**
	 * 部分排序方法
	 * @description 对一个整形数组的一部分进行从小到大排序
	 * @param array 进行排序的数组
	 * @param start array数组排序部分的第一个元素的下标
	 * @param end array数组排序部分的最后一个元素的下标
	 * @return 排序后的数组
	 */
	protected abstract Object[] sort(int start, int end);
}
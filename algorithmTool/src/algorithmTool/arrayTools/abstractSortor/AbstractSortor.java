package algorithmTool.arrayTools.abstractSortor;


import algorithmTool.arrayTools.conversionTool.ConversionTool;
import algorithmTool.math.mathTools.MathTool;

/**
 * 抽象排序类
 * @author BlazingPhoenix
 * @classDescription 提供一个排序方法“sort()”供外部调用<br>
 * 					   通过方法重载接收不同类型的数组<br>
 * 				 	   部分排序方法作为排序的实现方法，供子类实现
 */
public abstract class AbstractSortor {
	
	/**
	 * 引用类型数组排序方法
	 * @description 对一个引用类型的数组进行排序<br>
	 * 				若这个引用类型的元素非可排序元素（八种基本类型的封装类、字符串、BigDecimal除外）<br>
	 * 				则抛出异常；否则返回排序后的新数组（排序对原数组不产生影响）
	 * @param array 需要进行排序的引用类型数组
	 * @return 返回排序后的引用类型数组
	 */
	public Object[] sort(Object[] array)
	{
		if (!MathTool.canBeConvertedIntoBigDecimal(array[0]))
			throw new ClassCastException("Because the element type of" + array + " is " + array[0].getClass() + "," + array + " is not an array that can be sorted");
		return privateSort(array);
	}
	
	/**
	 * 比特型数组排序方法
	 * @param array 需要进行排序的比特型数组
	 * @return 返回排序后的引用类型数组
	 */
	public byte[] sort(byte[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		byte newArray[] = new byte[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Byte) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 短整型数组排序方法
	 * @param array 需要进行排序的短整型数组
	 * @return 返回排序后的短整型数组
	 */
	public short[] sort(short[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		short newArray[] = new short[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Short) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 整型数组排序方法
	 * @param array 需要进行排序的整型数组
	 * @return 返回排序后的整型数组
	 */
	public int[] sort(int[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		int newArray[] = new int[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Integer) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 长整型数组排序方法
	 * @param array 需要进行排序的长整型数组
	 * @return 返回排序后的长整型数组
	 */
	public long[] sort(long[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		long newArray[] = new long[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Long) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 浮点型数组排序方法
	 * @param array 需要进行排序的浮点型数组
	 * @return 返回排序后的浮点型数组
	 */
	public float[] sort(float[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		float newArray[] = new float[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Float) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 双精度浮点型数组排序方法
	 * @param array 需要进行排序的双精度浮点型数组
	 * @return 返回排序后的双精度浮点型数组
	 */
	public double[] sort(double[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		double newArray[] = new double[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Double) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 字符型数组排序方法
	 * @param array 需要进行排序的字符型数组
	 * @return 返回排序后的字符型数组
	 */
	public char[] sort(char[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		char newArray[] = new char[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Character) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 布尔型数组排序方法
	 * @param array 需要进行排序的布尔型数组
	 * @return 返回排序后的布尔型数组
	 */
	public boolean[] sort(boolean[] array)
	{
		Object ObjectArray[] = sort(ConversionTool.ObjectArrayOf(array));
		boolean newArray[] = new boolean[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = (Boolean) ObjectArray[i];
		return newArray;
	}
	
	/**
	 * 元素交换
	 * @description 将数组的两个元素进行交换
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	protected void exchange(Object[] array, int index1, int index2)
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
	public void getSortTime(Object[] array)
	{
		long startTime = System.currentTimeMillis();
		sort(array, 0, array.length - 1);
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - startTime) + "毫秒");
	}
	
	/**
	 * 私有排序方法
	 * @description 对一个整数数组进行从小到大排序<br>
	 * 				将排序后的结果放在一个新数组中并返回<br>
	 * @param array 进行排序的数组
	 * @return 排序后的数组
	 */
	private Object[] privateSort(Object[] array)
	{
		Object[] newArray = array.clone();
		return sort(newArray, 0, array.length - 1);
	}
	
	/**
	 * 部分排序方法
	 * @description 对一个整形数组的一部分进行从小到大排序
	 * @param array 进行排序的数组
	 * @param start array数组排序部分的第一个元素的下标
	 * @param end array数组排序部分的最后一个元素的下标
	 * @return 排序后的数组
	 */
	protected abstract Object[] sort(Object[] array, int start, int end);
}
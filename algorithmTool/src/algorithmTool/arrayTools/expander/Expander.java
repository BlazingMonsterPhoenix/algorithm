package algorithmTool.arrayTools.expander;
/**
 * 数组扩容器
 * @author BlazingPhoenix
 *
 */
public class Expander {
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将char类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static char[] expandToDouble(char[] array)
	{
		char[] newArray = new char[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将short类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static short[] expandToDouble(short[] array)
	{
		short[] newArray = new short[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将int类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static int[] expandToDouble(int[] array)
	{
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将long类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static long[] expandToDouble(long[] array)
	{
		long[] newArray = new long[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将float类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static float[] expandToDouble(float[] array)
	{
		float[] newArray = new float[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将double类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static double[] expandToDouble(double[] array)
	{
		double[] newArray = new double[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将byte类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static byte[] expandToDouble(byte[] array)
	{
		byte[] newArray = new byte[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将boolean类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static boolean[] expandToDouble(boolean[] array)
	{
		boolean[] newArray = new boolean[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * 增大到原来的两倍
	 * @description 使用一般方法将引用类型数组<br>
	 * 				增大到原来的两倍
	 * @param array 扩容的数组
	 * @return 扩容后的数组
	 */
	public static Object[] expandToDouble(Object[] array)
	{
		Object[] newArray = new Object[array.length * 2];
		for (int i = 0; i < array.length; i ++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
}

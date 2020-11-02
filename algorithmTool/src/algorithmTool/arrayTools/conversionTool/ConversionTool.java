package algorithmTool.arrayTools.conversionTool;

/**
 * 数组转换工具
 * @author BlazingPhoenix
 * @classDescription 将基本数据类型的数组转化为对应的引用类型数组
 * 
 */
public class ConversionTool {
	
	/**
	 * 将比特型数组转化为Byte数组
	 * @param array 需要转换的比特型数组
	 * @return 转换成的Byte数组
	 */
	public static Byte[] convert(byte[] array)
	{
		Byte newArray[] = new Byte[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将短整型数组转化为Short数组
	 * @param array 需要转换的短整型数组
	 * @return 转换成的Short数组
	 */
	public static Short[] convert(short[] array)
	{
		Short newArray[] = new Short[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将整型数组转化为Integer数组
	 * @param array 需要转换的整型数组
	 * @return 转换成的Integer数组
	 */
	public static Integer[] convert(int[] array)
	{
		Integer newArray[] = new Integer[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将长整型数组转化为Long数组
	 * @param array 需要转换的长整型数组
	 * @return 转换成的Long数组
	 */
	public static Long[] convert(long[] array)
	{
		Long newArray[] = new Long[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将浮点型数组转化为Float数组
	 * @param array 需要转换的浮点型数组
	 * @return 转换成的Float数组
	 */
	public static Float[] convert(float[] array)
	{
		Float newArray[] = new Float[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将双精度浮点型数组转化为Double数组
	 * @param array 需要转换的双精度浮点型数组
	 * @return 转换成的Double数组
	 */
	public static Double[] convert(double[] array)
	{
		Double newArray[] = new Double[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将字符型数组转化为Character数组
	 * @param array 需要转换的字符型数组
	 * @return 转换成的Character数组
	 */
	public static Character[] convert(char[] array)
	{
		Character newArray[] = new Character[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将布尔型数组转化为Boolean数组
	 * @param array 需要转换的布尔型数组
	 * @return 转换成的Boolean数组
	 */
	public static Boolean[] convert(boolean[] array)
	{
		Boolean newArray[] = new Boolean[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
}

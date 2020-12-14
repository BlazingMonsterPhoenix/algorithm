package algorithmTool.arrayTools.auxiliaryTools;

/**
 * 数组转换工具
 * @author BlazingPhoenix
 * @classDescription 将基本数据类型的数组转化为对应的引用类型数组<br>
 * 					   或将引用类型数组转化为对应的基本数据类型数组
 */
public class ConversionTool {
	
	/**
	 * 将比特型数组转化为Byte数组
	 * @param array 需要转换的比特型数组
	 * @return 转换成的Byte数组
	 */
	public static Byte[] ObjectArrayOf(byte[] array)
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
	public static Short[] ObjectArrayOf(short[] array)
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
	public static Integer[] ObjectArrayOf(int[] array)
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
	public static Long[] ObjectArrayOf(long[] array)
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
	public static Float[] ObjectArrayOf(float[] array)
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
	public static Double[] ObjectArrayOf(double[] array)
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
	public static Character[] ObjectArrayOf(char[] array)
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
	public static Boolean[] ObjectArrayOf(boolean[] array)
	{
		Boolean newArray[] = new Boolean[array.length];
		for (int i = 0; i < array.length; i ++)
			newArray[i] = array[i];
		return newArray;
	}
	
	/**
	 * 将Byte数组转化为整型数组
	 * @param array 需要转化的Byte型数组
	 * @return 转换成的比特型数组
	 */
	public static byte[] byteArrayOf(Object[] array)
	{
		byte newArray[] = new byte[array.length];
		if (array[0] instanceof Byte)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Byte)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Integer.");
		return newArray;
	}
	
	/**
	 * 将Short数组转化为整型数组
	 * @param array 需要转化的Short型数组
	 * @return 转换成的短整型数组
	 */
	public static short[] shortArrayOf(Object[] array)
	{
		short newArray[] = new short[array.length];
		if (array[0] instanceof Short)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Short)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Short.");
		return newArray;
	}
	
	/**
	 * 将Integer数组转化为整型数组
	 * @param array 需要转化的Integer型数组
	 * @return 转换成的整型数组
	 */
	public static int[] intArrayOf(Object[] array)
	{
		int newArray[] = new int[array.length];
		if (array[0] instanceof Integer)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Integer)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Integer.");
		return newArray;
	}
	
	/**
	 * 将Long数组转化为整型数组
	 * @param array 需要转化的Long型数组
	 * @return 转换成的整型数组
	 */
	public static long[] longArrayOf(Object[] array)
	{
		long newArray[] = new long[array.length];
		if (array[0] instanceof Long)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Long)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Long.");
		return newArray;
	}
	
	/**
	 * 将Float数组转化为浮点型数组
	 * @param array 需要转化的Float型数组
	 * @return 转换成的浮点型数组
	 */
	public static float[] floatArrayOf(Object[] array)
	{
		float newArray[] = new float[array.length];
		if (array[0] instanceof Float)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Float)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Float.");
		return newArray;
	} 
	
	
	/**
	 * 将Double数组转化为双精度浮点型数组
	 * @param array 需要转化的Double型数组
	 * @return 转换成的双精度浮点型数组
	 */
	public static double[] doubleArrayOf(Object[] array)
	{
		double newArray[] = new double[array.length];
		if (array[0] instanceof Double)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Double)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Double.");
		return newArray;
	}
	
	/**
	 * 将Character数组转化为字符型数组
	 * @param array 需要转化的Character型数组
	 * @return 转换成的字符型数组
	 */
	public static char[] charArrayOf(Object[] array)
	{
		char newArray[] = new char[array.length];
		if (array[0] instanceof Character)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Character)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Character.");
		return newArray;
	}
	
	/**
	 * 将Boolean数组转化为布尔型数组
	 * @param array 需要转化的Boolean型数组
	 * @return 转换成的布尔型数组
	 */
	public static boolean[] booleanArrayOf(Object[] array)
	{
		boolean newArray[] = new boolean[array.length];
		if (array[0] instanceof Boolean)
		{
			for (int i = 0; i < array.length; i ++)
				newArray[i] = (Boolean)array[i];
		}
		else 
			throw new ClassCastException("Not possible to coerce param:array from " + array[0].getClass() + " into Boolean.");
		return newArray;
	}
}

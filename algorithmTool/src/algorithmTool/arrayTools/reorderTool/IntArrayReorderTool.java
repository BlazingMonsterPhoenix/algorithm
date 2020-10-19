package algorithmTool.arrayTools.reorderTool;

public class IntArrayReorderTool {
	
	/**
	 * 随机打乱整数数组
	 * @description 将数组打乱<br>
	 * 				方法为将第一个元素与任一元素交换，然后对第二个元素做相同操作，以此类推<br>
	 * 				打乱效果不理想，因为结果分布不均匀
	 * @param array 等待被打乱的数组
	 */
	public static void disaster(int[] array)
	{
		for (int i = 0; i < array.length; i ++)
		{
			int x = (int)(Math.random() * array.length);
			exchange(array, i, x);
		}
	}
	
	/**
	 * 将整数数组倒转
	 * @param array 倒转的整数数组
	 */
	public static void reverse(int[] array)
	{
		for (int i = 0; i < array.length / 2; i ++)
			exchange(array, i, array.length - 1 - i);
	}
	
	/**
	 * 元素交换
	 * @description 将一个数组的两个元素进行交换
	 * @param array 进行修改的数组
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	protected static void exchange(int[] array, int index1, int index2)
	{
		int a = array[index1];
		array[index1] = array[index2];
		array[index2] = a;
	}
}

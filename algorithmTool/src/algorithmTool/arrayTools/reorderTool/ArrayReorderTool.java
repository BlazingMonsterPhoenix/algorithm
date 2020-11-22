package algorithmTool.arrayTools.reorderTool;
/**
 * 数组重排序工具
 * @author BlazingPhoenix
 */
public class ArrayReorderTool {
	
	/**
	 * 随机打乱整数数组
	 * @description 将数组打乱<br>
	 * 				方法为将第一个元素与任一元素交换，然后对第二个元素做相同操作，以此类推<br>
	 * 				打乱效果不理想，因为结果分布不均匀
	 * @param array 等待被打乱的数组
	 */
	public static Object[] disaster(Object[] array)
	{
		for (int i = 0; i < array.length; i ++)
		{
			int x = (int)(Math.random() * array.length);
			exchange(array, i, x);
		}
		return array;
	}
	
	/**
	 * 将整数数组倒转
	 * @param array 倒转的整数数组
	 */
	public static Object[] reverse(Object[] array)
	{
		for (int i = 0; i < array.length / 2; i ++)
			exchange(array, i, array.length - 1 - i);
		return array;
	}
	
	/**
	 * 元素交换
	 * @description 将一个数组的两个元素进行交换
	 * @param array 进行修改的数组
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	public static void exchange(Object[] array, int index1, int index2)
	{
		Object a = array[index1];
		array[index1] = array[index2];
		array[index2] = a;
	}
	
	/**
	 * 插入
	 * @description 将下标为insert的元素插入到下标为index的位置上<br>
	 * 				下标在index和insert之间的元素相应左移或右移
	 * @param array 数组
	 * @param index 插入的位置的下标
	 * @param insert 插入的元素的下标
	 */
	public static void insert(Object[] array, int index, int insert)
	{
		if (insert == index)
			return;
		Object flag = array[insert];
		if (insert > index)
		{
			for (int i = insert; i > index; i --) {
				array[i] = array[i - 1];
			}
		}
		else
		{
			for (int i = insert; i < index; i ++) {
				array[i] = array[i + 1];
			}
		}
		array[index] = flag;
	}
}

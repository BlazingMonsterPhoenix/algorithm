package algorithmTool.arrayTools.auxiliaryTools;

/**
 * 数组重排序工具
 * @author BlazingPhoenix
 */
public class ArrayReorderTool {
	
	/**
	 * 随机打乱数组
	 * @deprecated 逻辑存在问题<br>
	 * 			         在元素数量为n的数组中，好的打乱算法应该使得结果存在n!种几率相同的可能性<br>
	 * 			         并且每个元素出现在任一位置的可能性都相同且为1/n<br>
	 * 			         而此方法的可能性为n的n次方，显然不满足条件。<br>
	 * 			         打乱效果不理想，因为结果分布不均匀。不建议使用
	 * @description 将数组打乱<br>
	 * 				方法为将第一个元素与任一元素交换，然后对第二个元素做相同操作，以此类推<br>
	 * @param array 等待被打乱的数组
	 */
	public static Object[] disasterOld(Object[] array)
	{
		for (int i = 0; i < array.length; i ++)
		{
			int x = (int)(Math.random() * array.length);
			exchange(array, i, x);
		}
		return array;
	}
	
	/**
	 * 随机打乱数组
	 * @description 将数组打乱<br>
	 * 				先从数组中随机抽取一个元素作为新数组第一个元素，再从剩下的中抽取一个作为第二个元素，以此类推<br>
	 * 				以抽排类比：n个人从n张牌的牌堆中抽牌。依次随机抽取，每个人拿到任一一张牌的概率相同
	 * @param array 等待被打乱的数组
	 * @return 打乱后的数组
	 */
	public static Object[] disaster(Object[] array)
	{
		Object[] newArray = array.clone();
		for (int i = 0; i < newArray.length - 1; i ++)
		{
			int x = (int)(Math.random() * newArray.length - i) + i;
			exchange(newArray, i, x);
		}
		return newArray;
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

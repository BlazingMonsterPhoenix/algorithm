package algorithmTool.arrayTool.abstractSortor;
/**
 * 抽象排序类
 * @author FieryPhoenix
 */
public abstract class AbstractIntSortor {
	
	/**
	 * 排序方法
	 * @deprecated
	 * @description 对一个整数数组进行从小到大排序，输出排序所用的时间<br>
	 * 				主要用于测试
	 * @param array 进行排序的数组
	 */
	public void sort(int[] array, int a)
	{
		long startTime = System.currentTimeMillis();
		sort(array, 0, array.length - 1);
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
	public int[] sort(int[] array)
	{
		int[] newArray = array.clone();
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
	protected abstract int[] sort(int[] array, int start, int end);
	
	/**
	 * 元素交换
	 * @description 将一个数组的两个元素进行交换
	 * @param array 进行修改的数组
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	protected  void exchange(int[] array, int index1, int index2)
	{
		int a = array[index1];
		array[index1] = array[index2];
		array[index2] = a;
	}
}

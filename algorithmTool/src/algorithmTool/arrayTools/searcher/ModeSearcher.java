package algorithmTool.arrayTools.searcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithmTool.arrayTools.auxiliaryTools.ArrayReorderTool;
import algorithmTool.arrayTools.sortor.MergeSortor;
import dataStructure.tree.TrinaryTree;

/**
 * 众数搜索类
 * @author BlazingPhoenix
 * @optimizationItem 优化项：简化getModeTreeList方法代码（代码过长）；
 * 					   考虑三叉树和二叉树算法的时间复杂度问题
 */
public class ModeSearcher {
	
	/*************最强版本区***************/
	
	/**
	 * 通过升级版计数法查找众数(Hash+计数)
	 * @description 通过升级版计数法从数组中搜索众数，并以列表的形式返回<br>
	 * 				利用HashMap，遍历一遍数组并记录下每种元素出现的次数<br>
	 * 				时间复杂度为O(n)
	 * @param array 数组
	 * @return 带有所有众数的列表
	 */
	public static List<Object> searchByCountPlus(Object[] array)
	{
		List<Object> modeList = new ArrayList<Object>();
		Map<Object,Integer> counter = new HashMap<Object,Integer>();
		for (int i = 0; i < array.length; i ++)
		{
			if (!counter.containsKey(array[i])){
				counter.put(array[i], 1);
			}
			else{
				counter.put(array[i], counter.get(array[i]) + 1);
			}
		}
		int max = 0;
		for (Object key : counter.keySet())
		{
			if (counter.get(key) > max)
			{
				modeList.clear();
				modeList.add(key);
				max = counter.get(key);
			}
			else if (counter.get(key) == max){
				modeList.add(key);
			}
		}
		return modeList;
	}
	
	
	/*************常规思路区**************/
	/*********正常人一般能想到的方法**********/
	
	/**
	 * 通过计数法查找众数（普适版）
	 * @description 通过计数法从数组中搜索众数，并以列表的形式返回<br>
	 * 				先遍历一遍数组，记录出现过的元素<br>
	 * 				然后使用searchByCount方法返回带有众数的列表
	 * @param array 数组
	 * @return 众数列表
	 */
	public static List<Object> search(Object[] array)
	{
		List<Object> roster = new ArrayList<Object>();
		for (int i = 0; i < array.length; i ++)
		{
			if (!roster.contains(array[i])){
				roster.add(array[i]);
			}
		}
		return searchByCount(array, roster);
	}
	
	/**
	 * 通过计数法查找众数
	 * @description 通过计数法从数组中搜索众数，并以列表的形式返回<br>
	 *              计数法：传入一个“名单”，名单中记录数组中所有可能出现的元素<br>
	 *              遍历数组，计算每种元素出现的次数，比较出现的次数
	 * @param array 数组
	 * @param roster 名单
	 * @return 众数列表
	 */
	public static List<Object> searchByCount(Object[] array,List<Object> roster)
	{
		//众数列表
		List<Object> modeList = new ArrayList<Object>();
		int num[] = new int[roster.size()];
		//遍历一遍数组，记录名单中的元素出现的次数
		for (int i = 0; i < array.length; i ++)
		{
			int x = 0;
			for (; x < roster.size(); x ++)
			{
				if (roster.get(x).equals(array[i])){
					break;
				}
			}
			num[x] ++;
		}
		//遍历一遍名单，将名单中出现次数最多的元素加入众数列表
		for (int i = 0,max = 0; i < roster.size(); i ++)
		{
			if (num[i] > max)
			{
				modeList.clear();
				modeList.add(roster.get(i));
				max = num[i];
			}
			else if (num[i] == max){
				modeList.add(roster.get(i));
			}
		}
		return modeList;
	}
	
	/**
	 * 通过排序的方法查找众数
	 * @deprecated 速度太慢，不建议使用
	 * @description 通过排序方法从数组中搜索众数，并以列表的形式返回<br>
	 * 				先将数组从小到大排序，然后顺序读取排序后的数组，记录每个元素出现的次数<br>
	 * 				速度一般，稳定性好<br>
	 * @param array 数组
	 * @return 存有众数的列表
	 */
	public static List<Object> searchBySorting(Object[] array)
	{
		List<Object> modeList = new ArrayList<Object>();
		//对数组进行排序
		Object newArray[] = new MergeSortor().sort(array);
		int maxTimes = 0;					//出现最多次的元素出现的次数
		Object flag = newArray[0];			//当前正在比较的元素
		int times = 1;						//当前正在比较的元素出现的次数
		for (int i = 1; i < newArray.length; i ++)
		{
			if (newArray[i].equals(flag))
				times ++;
			else
			{
				if (times > maxTimes)
				{
					modeList.clear();
					modeList.add(flag);
					maxTimes = times;
				}
				else if (times == maxTimes)
				{
					modeList.add(flag);
				}
				times = 1;
				flag = newArray[i];
			}
		}
		return modeList;
	}
	
	/**************花里胡哨区****************/
	/*************一些看起来很牛逼其实没什么卵用的方法********/
	
	/**
	 * 使用“装车法”算法搜索众数
	 * @date 2020/11/21
	 * @author 周峥宇
	 * @deprecated 速度太慢，且稳定性不好，不建议使用
	 * @description 利用“装车法”算法从数组中搜索众数，并以列表的形式返回<br>
	 * 				装车法：设置n辆车，这些车上装的每个元素必须都不相同；将数组中的元素依次放上车<br>
	 * 				装完后，最后一辆车上的元素均为众数<br>
	 * 				原创算法，速度一般，且稳定性差<br>
	 * 				适用于数组中元素种类数量比较有限；数组元素种类数量最好是已知的，并且出现频率比较相近的场景<br>
	 * 				元素种类数量不清楚时，rosterLength可填array.length，但是效果不佳
	 * @param array 数组
	 * @rosterLength 每辆卡车上能装的元素的数量（即，数组中可能需要
	 * @return 存有众数的列表
	 */
	public static List<Object> searchByEntrucking(Object[] array, int rosterLength)
	{
		//众数列表
		List<Object> modeList = new ArrayList<Object>();	
		//待装货的“卡车”，第n辆卡车中所装的元素为array中下标为trucks[n]和trucks[n-1]之间的元素
		int trucks[] = new int[array.length];	
		//准备好第一辆车（将数组的第一个元素装入第一辆卡车）
		trucks[1] = 1;	
		//当前已经装有“货物”的卡车的数量
		int numOfTrucks = 1;	
		//已装满的卡车的数量
		int fullTrucks = rosterLength > 1 ? 0 : 1;	
		//依次将数组中的元素装上车
		for (int i = 1; i < array.length; i ++)
		{
			//将当前元素装车，获取它装上的车的号码（即，上了第几辆车，注意号码是从0开始计的）
			int entruckedId = entruck(array, i, trucks, numOfTrucks, fullTrucks, rosterLength);
			fullTrucks += trucks[entruckedId + 1] - trucks[entruckedId] == rosterLength ? 1 : 0;
			//若装上的车的号码与当前装有货物的车的数量相等（说明货物装上了一辆空车，当前装有货物的车数需要+1）
			if (entruckedId == numOfTrucks)
			{
				numOfTrucks += 1;
				trucks[numOfTrucks] = i + 1;
			}
		}
		//取出最后一辆车中的所有“货物”，这些“货物”就是众数
		for (int i = trucks[numOfTrucks - 1]; i < trucks[numOfTrucks]; i ++) {
			modeList.add(array[i]);
		}
		return modeList;
	}
	
	/**
	 * 将数组中下标为goodsId的元素按照“装车法”算法规则“装车”
	 * @param array 数组
	 * @param goodsId 当前正在装车的“货物“id
	 * @param trucks 卡车队列
	 * @param numOfTrucks 当前装有货物的卡车数量
	 * @return 货物装上的卡车的卡车编号
	 */
	private static int entruck(Object[] array, int goodsId, int[] trucks, int numOfTrucks, int fullTrucks,int rosterLength)
	{
		//正在检查的卡车的下标，从第一辆未装满的卡车开始检查
		int checkingTruckId = fullTrucks;
		//依次检查已经装有货物但还未装满的卡车
		for (; checkingTruckId < numOfTrucks ; checkingTruckId ++)
		{
			//正在检查的卡车中的第一个货物
			int i = trucks[checkingTruckId];
			//依次检查卡车中的货物
			for (; i <= trucks[checkingTruckId + 1]; i ++)
			{
				if (array[i].equals(array[goodsId]))
					break;
			}
			//若正在检查的卡车中没有当前类型的元素，将该元素装入当前正在检查的卡车
			if (i >= trucks[checkingTruckId + 1])
			{
				ArrayReorderTool.insert(array, i - 1, goodsId);
				for (int j = checkingTruckId + 1; j <= numOfTrucks; j ++)
					trucks[j] += 1;
				return checkingTruckId;
			}
		}
		//当前已经装有货物的卡车中均已含有当前待装车元素，当前元素只能放入一辆空车中
		return numOfTrucks;
	}
	
	/**
	 * 利用三叉树搜索数组中的众数众数
	 * @deprecated 不建议使用。相对于二叉树来说多此一举，而且速度贼几把慢
	 * @description 利用三叉树从数组中搜索众数，并以列表的形式返回<br>
	 * 				三叉树规则：三叉树的，左子树的内容小于三叉树，右子树内容大于三叉树，中子树的内容与三叉树相同<br>
	 * 				先将数组按上述规则转化为三叉树，然后利用三叉树的特性遍历三叉树找到众数<br>
	 * 				返回带有众数的列表，如果有多个元素出现次数相同且都是最多，列表中就有多个元素
	 * @param array 数组
	 * @return 带有众数的列表
	 */
	public static List<Object> searchByTrinaryTree(Object[] array)
	{
		//将数组转化为三叉树（三叉树左子树的内容小于三叉树，右子树的内容大于三叉树，中子树的内容等于三叉树）
		TrinaryTree tree = new TrinaryTree(array[0]);
		for (int i = 1; i < array.length; i ++)
			tree.add(new TrinaryTree(array[i]));
		List<TrinaryTree> modeTreeList = getModeTreeList(tree);			//获取三叉树众数列表
		List<Object> modeList = new ArrayList<Object>();			//众数列表
		//三叉树列表转化为众数列表
		for (TrinaryTree treeElement : modeTreeList)
		{
			modeList.add(treeElement.getContent());
		}
		return modeList;
	}
	
	
	/**
	 * 获取三叉树中的，内容出现次数最多的三叉树的列表
	 * @description 搜索当前三叉树及其所有子树中，内容出现的次数最多的三叉树<br>
	 * 				将这些三叉树存入一个列表中并返回
	 * @param tree 三叉树
	 * @return 装有三叉树的列表
	 */
	private static List<TrinaryTree> getModeTreeList(TrinaryTree tree)
	{
		List<TrinaryTree> mode = new ArrayList<TrinaryTree>();
		if (tree == null)
			return mode;
		List<TrinaryTree> leftMode = getModeTreeList(tree.getLeft());		//左子树中的众数列表
		List<TrinaryTree> rightMode = getModeTreeList(tree.getRight());		//右子树中的众数列表
		int leftDepth = leftMode.size() == 0 ? 0 : leftMode.get(0).getDepth();			//左子树中众数出现的次数
		int rightDepth = rightMode.size() == 0 ? 0 : rightMode.get(0).getDepth();		//右子树中众数出现的次数
		int depth = tree.getDepth();
		if (leftDepth > rightDepth)				//若左子树众数次数大于右子数
		{
			if (leftDepth < depth)			//左子树与当前节点比较
			{
				mode.add(tree);
				return mode;
			}
			else if (leftDepth == depth)
				leftMode.add(tree);
			return leftMode;
		}
		else if (rightDepth > leftDepth)		//右子树众数次数大于左子树
		{
			if (rightDepth < depth)				//右子树与当前节点比较
			{
				mode.add(tree);
				return mode;
			}
			else if (rightDepth == depth)
				rightMode.add(tree);
			return rightMode;
		}
		else
		{
			leftMode.addAll(rightMode);
			if (tree.getDepth() > leftDepth)
			{
				mode.add(tree);
				return mode;
			}
			else if (leftDepth == tree.getDepth())
				leftMode.add(tree);
			return leftMode;
		}
	}
	
	
}

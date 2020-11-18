package algorithmTool.arrayTools.searcher;

import java.util.ArrayList;
import java.util.List;
import dataStructure.tree.TrinaryTree;

/**
 * 众数搜索类
 * @author BlazingPhoenix
 *
 */
public class ModeSearcher {
	
	/**
	 * 利用三叉树搜索数组中的众数众数
	 * @description 利用三叉树从数组中搜索众数列表<br>
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
		else
		{
			List<TrinaryTree> leftMode = getModeTreeList(tree.getLeft());		//左子树中的众数列表
			List<TrinaryTree> rightMode = getModeTreeList(tree.getRight());		//右子树中的众数列表
			int leftDepth = leftMode.get(0).getDepth();			//左子树中众数出现的次数
			int rightDepth = rightMode.get(0).getDepth();		//右子树中众数出现的次数
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
				if (rightDepth < depth)			//右子树与当前节点比较
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
				if (leftDepth == tree.getDepth())
					leftMode.add(tree);
				return leftMode;
			}
		}
	}
	
	
}

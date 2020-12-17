package dataStructure.tree.pseudoPointerTree;

import java.lang.reflect.Array;


/**
 * 伪指针n叉树
 * @author BlazingPhoenix
 * @param <E>
 */
public abstract class AbstractNaryTree<E> {
	
	//存储数据的类型
	private Class<?> type;
	//枝条
	protected Branch branch;
	//分叉数
	private int bifurcation;
	//当前正在操作的树的根节点，在整棵树中的下标值+1
	protected int root;
	
	/**
	 * 构造方法
	 */
	protected AbstractNaryTree(int bifurcation)
	{
		this.bifurcation = bifurcation;
		root = 1;
	}
	
	/**
     * 获取一个E类型的数组
     * @param size 数组的大小
     * @return E类型的数组
     */
	@SuppressWarnings("unchecked")
    private TreeNode<E>[] createArray(int size) {
        return (TreeNode<E>[]) Array.newInstance(type, size);
    }
	
	/**
	 * 内部类：枝条（底层数据逻辑）
	 * @author BlazingPhoenix
	 *
	 */
	private class Branch
	{
		private TreeNode<E>[] tree;
		private int size = 0;
		
		/**
		 * 设置数组中下标为index的节点
		 * @param index 下标
		 * @param object 节点
		 */
		protected void set(int index, TreeNode<E> content)
		{
			if (tree == null)
			{
				type = content.getClass();
				tree = createArray((int)Math.pow(bifurcation, 3) - 1);
				this.size = tree.length;
			}
			//extendIfNeedTo(index);
			tree[index] = content;
		}
		
	}
	
}

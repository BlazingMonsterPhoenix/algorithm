package dataStructure.tree.pseudoPointerTree;

import java.lang.reflect.Array;

import dataStructure.tree.arrayTree.AbstractArrayNaryTree;


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
	 * @param bifurcation 树的分叉数
	 */
	protected AbstractNaryTree(int bifurcation)
	{
		this.bifurcation = bifurcation;
		root = 0;
		branch = new Branch();
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
	 * 判断树是否为空
	 * @return 若是，则返回true
	 */
	public boolean isEmpty()
	{
		return branch.isEmpty();
	}
	
	/**
	 * 设置n叉树当前节点的内容
	 * @param content 内容
	 */
	public void setContent(E content)
	{
		TreeNode<E> node = new TreeNode<E>(content);
		branch.set(node);
	}
	
	/**
	 * 获取n叉树当前节点的内容
	 * @return 内容
	 */
	public E getContent()
	{
		return branch.get(root).getContent();
	}
	
	/**
	 * 寄生
	 * @description 使自身的数据与另一棵树的相同<br>
	 * 				且自身的数据改变和它的数据改变会互相影响<br>
	 * 				（寄生于另一棵树）
	 * @param anotherTree 另一棵树
	 */
	protected void parasitize(AbstractNaryTree<E> anotherTree)
	{
		this.branch = anotherTree.branch;
	}
	
	/**
	 * 内部类：枝条（底层数据逻辑）
	 * @author BlazingPhoenix
	 *
	 */
	protected class Branch
	{
		private TreeNode<E>[] tree;
		private int size = 0;
		//当前tree数组用了多少
		private int flag = 0;
		
		/**
		 * 判断当前树是否为空
		 * @return 若是则返回true
		 */
		private boolean isEmpty()
		{
			return tree == null || tree[root - 1] == null;
		}
		
		/**
		 * 获得n叉树数组中下标为index的节点
		 * @param index 下标
		 * @return 下标为index的节点
		 */
		protected TreeNode<E> get(int index)
		{
			//防止数组越界
			if (index > size || index < 0)
				return null;
			return tree[index];
		}
		
		/**
		 * 设置数组中下标为index的节点
		 * @param index 下标
		 * @param object 节点
		 */
		protected void set(TreeNode<E> content)
		{
			if (tree == null)
			{
				type = content.getClass();
				tree = createArray((int)Math.pow(bifurcation, 3) - 1);
				this.size = tree.length;
			}
			extendIfNeedTo(flag);
			//设置分叉数
			content.setBifurcation(bifurcation);
			tree[flag] = content;
		}
		
		/**
		 * 在需要时进行扩容
		 * @description 判断是否需要扩容，如果需要则进行扩容
		 * @param require 需要的容量
		 */
		private void extendIfNeedTo(int require)
		{
			if (require >= size)
			{
				extend();
			}
		}
		
		/**
		 * 数组扩容
		 */
		private void extend()
		{
			//增加一层
			TreeNode<E>[] newTree = createArray(tree.length * bifurcation - 1);
			for (int i = 0; i < tree.length; i ++)
			{
				newTree[i] = tree[i];
			}
			//指向新的地址
			tree = newTree;
			this.size = tree.length;
		}
		
		protected int getSize()
		{
			return size;
		}
		
		protected int getFlag()
		{
			return this.flag;
		}
		
	}
	
}

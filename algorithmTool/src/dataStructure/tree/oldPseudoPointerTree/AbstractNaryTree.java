package dataStructure.tree.oldPseudoPointerTree;

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
	private Branch branch;
	//分叉数
	private int bifurcation;
	//当前正在操作的树的根节点，在整棵树中的下标值+1
	protected int root;
	
	/**
	 * @deprecated
	 */
	public void printNodes()
	{
		for (int i = 0; i < branch.getFlag(); i ++)
		{
			System.out.println("branch[" + i + "] = " + branch.tree[i].getContent());
		}
	}
	
	/**
	 * 构造方法
	 * @param bifurcation 树的分叉数
	 */
	protected AbstractNaryTree(int bifurcation)			//分支必须大于1，否则抛异常
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
	
	protected Branch getBranch()
	{
		this.branch.setRoot(root);
		return branch;
	}
	
	/**
	 * 判断树是否为空
	 * @return 若是，则返回true
	 */
	public boolean isEmpty()
	{
		return getBranch().isEmpty();
	}
	
	/**
	 * 设置n叉树当前节点的内容
	 * @param content 内容
	 */
	public void setContent(E content)
	{
		TreeNode<E> node = new TreeNode<E>(content);
		node.setBifurcation(bifurcation);
		getBranch().set(node);
	}
	
	/**
	 * 获取n叉树当前节点的内容
	 * @return 内容
	 */
	public E getContent()
	{
		if (this.isEmpty())
			return null;
		return getBranch().get(root).getContent();
	}
	
	/**
	 * 获取指针
	 * @param index 指针下标
	 * @return 指针的值
	 */
	protected int getPointer(int index)
	{
		return getBranch().get(root).getPseudoPointer(index);
	}
	
	/**
	 * 设置指针
	 * @param index 指针下标
	 * @param value 指针的值
	 */
	public void setPointer(int index, int value)
	{
		getBranch();
		if (value > branch.getFlag())
			return;
		if (value == branch.getFlag())
		{
			branch.extendIfNeedTo(value);
			branch.addFlag();
		}
		branch.get(root).setPseudoPointer(index, value);
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
		getBranch();
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
		private int root;
		
		/**
		 * 判断当前树是否为空
		 * @return 若是则返回true
		 */
		private boolean isEmpty()
		{
			return tree == null || tree[this.root] == null;
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
			{
				return null;
			}
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
				this.root = 0;
			}
			//extendIfNeedTo(flag);
			//设置分叉数
			content.setBifurcation(bifurcation);
			tree[this.root] = content;
			flag += flag == 0 ? 1 : 0;
		}
		
		protected void setRoot(int root)
		{
			this.root = root;
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
		
		protected void addFlag()
		{
			flag ++;
		}
		
	}
	
}

package dataStructure.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 抽象n叉树
 * @description 所有n叉树的父类（远古巨树）
 * @author BlazingPhoenix
 *
 */
public abstract class AbstractNaryTree<E> {
	
	//存储数据的类型
	private E e;
	private Class<E> type;
	//分叉数
	protected int bifurcation;
	//底层数据结构
	protected Branch tree;
	//当前正在操作的树的根节点，在整棵树中的下标值
	protected int root;
	
	/**
	 * 构造方法
	 */
	protected AbstractNaryTree()
	{
		type = (Class<E>) e.getClass();
		root = 0;
	}
	
    /**
     * 获取一个E类型的数组
     * @param size 数组的大小
     * @return E类型的数组
     */
	@SuppressWarnings("unchecked")
    private E[] createArray(int size) {
        return (E[]) Array.newInstance(type, size);
    }
	
	protected E[] getNodeList()
	{
		return this.tree.tree;
	}
	
	/**
	 * 寄生
	 * @description 使自身的数据与另一棵树的相同<br>
	 * 				且自身的数据改变和它的数据改变会互相影响<br>
	 * 				（寄生于另一棵树）
	 * @param anotherTree 另一棵树
	 */
	protected void parasitize(AbstractNaryTree anotherTree)
	{
		this.tree = anotherTree.tree;
	}
	
	/**
	 * 枝条
	 * @description n叉树底层数据存储类
	 * @author BlazingPhoenix
	 */
	protected class Branch
	{
		//初始化三层的n叉树
		private E[] tree = createArray((int)Math.pow(bifurcation, 3) - 1);
		private int size = tree.length;
		
		/**
		 * 获得n叉树数组中下标为index的节点
		 * @param index 下标
		 * @return 下标为index的节点
		 */
		public E get(int index)
		{
			//防止数组越界
			if (index > size || index < 0)
				return null;
			return tree[index];
		}
		
		/**
		 * 设置数组中下标为index的节点
		 * @param index 下标
		 * @param content 节点
		 */
		public void set(int index, E content)
		{
			tree[index] = content;
		}
		
		/**
		 * 在需要时进行扩容
		 * @description 判断是否需要扩容，如果需要则进行扩容
		 * @param require 需要的容量
		 */
		public void extendIfNeedTo(int require)
		{
			if (require > size)
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
			E[] newTree = createArray(tree.length * bifurcation - 1);
			for (int i = 0; i < tree.length; i ++)
			{
				newTree[i] = tree[i];
			}
			this.size = tree.length * bifurcation - 1;
			//指向新的地址
			tree = newTree;
		}
		
		public int getSize()
		{
			return size;
		}
	}
	
}

package dataStructure.tree.pseudoPointerTree;

import java.lang.reflect.Array;

import dataStructure.tree.pseudoPointerTree.TreeNode;

/**
 * 枝条
 * @description n叉伪指针树的底层数据结构类
 * @author BlazingPhoenix
 *
 */
public class Branch<E> {
	
	//存储数据的类型
	private Class<?> type;
	//存储树节点的数组
	private TreeNode<E>[] nodes;
	//当前数组的容量
	private int length;
	//当前有多少个节点
	private int size;
	//分叉数
	private int bifurcation;
	
	/**
	 * 无参构造方法
	 */
	public Branch()
	{
		length = 0;
		size = 0;
	}
	
	
	/**
	 * 判断以root为根的枝条是否为空
	 * @return 
	 */
	public boolean isEmpty(int root)
	{
		return nodes == null || root >= size || nodes[root] == null;
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
	 * 设置节点
	 * @param content 节点的内容
	 * @param root 节点在数组中的下标
	 */
	protected void set(E content, int root)
	{
		if (nodes == null)
		{
			type = content.getClass();
			nodes = createArray((int)Math.pow(bifurcation, 3) - 1);
			this.length = nodes.length;
		}
		if (root > size)
			return;				/**@Exception 抛出异常**/
		if (root == size)
		{
			/**扩容判断**/
			size ++;
		}
		nodes[root] = new TreeNode<E>(content, bifurcation);
	}
	
	/**扩容判断，在需要时扩容**/
	/**扩容**/
	/**获取节点的内容**/
	/**设置节点的指针**/
}

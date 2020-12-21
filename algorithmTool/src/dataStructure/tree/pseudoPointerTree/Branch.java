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
	protected Branch(int bifurcation)
	{
		length = 0;
		size = 0;
		this.bifurcation = bifurcation;
	}
	
	
	/**
	 * 判断以root为根的枝条是否为空
	 * @return 
	 */
	protected boolean isEmpty(int root)
	{
		return isNull(root) || nodes[root].getContent() == null;
	}
	
	/**
	 * 判断节点是否实例化
	 * @param root 节点在数组中的下标
	 * @return 若未实例化则返回true
	 */
	protected boolean isNull(int root)
	{
		return nodes == null || root >= size || nodes[root] == null;
	}
	
	/**
     * 获取一个E类型的数组
     * @param size 数组的大小
     * @return E类型的数组
     */
	@SuppressWarnings("unchecked")
    private TreeNode<E>[] createNodes(int size) {
        return (TreeNode<E>[]) Array.newInstance(type, size);
    }
	
	
	/**
	 * 在需要时扩容
	 * @description 判断数组是否需要扩容，如果需要，则扩容
	 * @param root 当前将要操作的节点在数组中的下标
	 */
	private void extendIfNeedTo(int root)
	{
		if (root >= this.length)
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
		TreeNode<E>[] newNodes = createNodes(nodes.length * bifurcation - 1);
		for (int i = 0; i < nodes.length; i ++)
		{
			newNodes[i] = nodes[i];
		}
		nodes = newNodes;
		this.length = nodes.length;
	}
	
	
	/**
	 * 设置节点
	 * @param node 节点
	 * @param root 节点在数组中的下标
	 */
	protected void set(TreeNode<E> node, int root)
	{
		if (nodes == null)
		{
			type = node.getClass();
			//初始化三层
			nodes = createNodes((int)(Math.pow(bifurcation, 3) - 1));
			this.length = nodes.length;
		}
		if (root > size)
			return;				/**@Exception 抛出异常**/
		if (root == size)
		{
			extendIfNeedTo(root);
			size ++;
		}
		nodes[root] = node;
	}
	
	
	/**
	 * 设置节点的内容
	 * @param content 内容
	 * @param root 节点在数组中的下标
	 */
	protected void setContent(E content, int root)
	{
		//单签节点未实例化，则不能设置内容。root为0则有可能是数组未初始化
		if (isNull(root) && root != 0)
		{
			return;				/**@Exception 抛出异常**/
		}
		//数组已初始化且节点已实例化
		if (nodes != null && nodes[root] != null)
		{
			nodes[root].setContent(content);
		}
		//说明是数组未初始化
		else
		{
			TreeNode<E> node = new TreeNode<E>(bifurcation);
			node.setContent(content);
			set(node, root);
		}
	}
	
	/**
	 * 获取节点的内容
	 * @param root 节点在数组中的下标
	 * @return 节点的内容
	 */
	protected E getContent(int root)
	{
		if (root >= length || root < 0 || nodes[root] == null)
		{
			return null;		/**@Exception 抛出异常**/
		}
		return nodes[root].getContent();
	}
	
	
	/**
	 * 设置指定节点的伪指针
	 * @param root 节点在数组中的下标
	 * @param index 伪指针在指针列表中的下标
	 * @param value 伪指针的值（指向数组中下标与此一致的元素）
	 */
	protected void setPoint(int root, int index, int value)
	{
		if (isEmpty(root))
		{
			return;				/**@Exception 抛出异常**/
		}
		if (value > size)
		{
			extendIfNeedTo(size);
			value = size;
			size ++;
		}
		nodes[root].setPointer(index, value);
	}
	
	
	/**
	 * 获取指定节点的伪指针的值
	 * @param root 节点在数组中的下标
	 * @param index 伪指针在指针列表中的下标
	 * @return 为指针的值
	 */
	protected int getPoint(int root, int index)
	{
		if (isEmpty(root))
		{
			return -1;
		}
		return nodes[root].getPointer(index);
	}
	
	
	/**
	 * 初始化指定节点的一个指定子节点
	 * @description 将指定节点的指定子节点初始化，无论它是否已经是一个实例化对象<br>
	 * 				根据伪指针查找指定子节点，若伪指针为-1，则说明子节点未实例化<br>
	 * 				子节点未实例化时，将数组中第一个空节点赋给子节点
	 * @param root 指定节点在数组中的下标
	 * @param index 指向子节点的伪指针
	 * @return 重新实例化后的子节点
	 * @deprecated 这玩意儿暂时没什么用
	 */
	protected int createSub(int root, int index)
	{
		if (isEmpty(root))
		{
			return -1;			/**@Exception 抛出异常**/
		}
		if (nodes[root].getPointer(index) == -1)
		{
			extendIfNeedTo(size);
			nodes[root].setPointer(index, size);
			size ++;
		}
		//重新实例化子节点
		nodes[nodes[root].getPointer(index)] = new TreeNode<E>(bifurcation);
		return nodes[root].getPointer(index);
	}
	
	
	/**
	 * 实例化化指定节点的一个指定子节点
	 * @description 如果指定节点的指定子节点未实例化，则将它实例化并返回它的下标
	 * @param root 指定节点在数组中的下标
	 * @param index 指向子节点的伪指针
	 * @return 实例化后的子节点的下标
	 */
	protected int createSubIfSubIsNull(int root, int index)
	{
		if (isEmpty(root))
		{
			return -1;			/**@Exception 抛出异常**/
		}
		if (nodes[root].getPointer(index) == -1)
		{
			extendIfNeedTo(size);
			nodes[root].setPointer(index, size);
			size ++;
			//实例化子节点
			nodes[nodes[root].getPointer(index)] = new TreeNode<E>(bifurcation);
		}
		return nodes[root].getPointer(index);
	}
	
}

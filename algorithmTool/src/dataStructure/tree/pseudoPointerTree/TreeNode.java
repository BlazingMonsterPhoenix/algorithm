package dataStructure.tree.pseudoPointerTree;

/**
 * 树节点
 * @author BlazingPhoenix
 * @param <E> 节点中存储的数据的类型
 */
public class TreeNode<E> {
	
	//内容
	private E content;
	//伪指针列表
	private int[] pseudoPointer;
	
	/**
	 * 构造方法
	 * @param bifurcation 分叉数
	 */
	public TreeNode(int bifurcation)
	{
		this.pseudoPointer = new int[bifurcation];
	}
	
}

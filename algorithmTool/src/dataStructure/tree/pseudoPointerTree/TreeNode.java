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
	 * 无参构造方法
	 */
	public TreeNode()
	{
		
	}
	
	/**
	 * 构造方法
	 * @param content 树节点的内容
	 */
	public TreeNode(E content)
	{
		this.content = content;
	}
	
	/**
	 * 构造方法
	 * @param bifurcation 分叉数
	 */
	/*public TreeNode(int bifurcation)
	{
		this.pseudoPointer = new int[bifurcation];
		for (int i = 0; i < pseudoPointer.length; i ++)
			pseudoPointer[i] = -1;
	}*/
	
	/**
	 * 设置分叉数
	 * @description 设置分叉数，并刷新指针列表
	 * @param bifurcation 分叉数
	 */
	public void setBifurcation(int bifurcation)
	{
		int flag = 0;
		//当前指针列表不为空，新的指针列表保留原来的值
		if (pseudoPointer != null && pseudoPointer.length > 0)
		{
			int[] newPointerList = new int[bifurcation];
			int length = pseudoPointer.length < bifurcation ? pseudoPointer.length : bifurcation;
			int i = 0;
			for (; i < length; i ++)
			{
				newPointerList[i] = pseudoPointer[i];
				
			}
			pseudoPointer = newPointerList;
			flag = i;
		}
		else
		{
			pseudoPointer = new int[bifurcation];
		}
		//-1表示空指针
		for (int i = flag; i < pseudoPointer.length; i ++)
			pseudoPointer[i] = -1;
	}
	
	/**
	 * 设置伪指针
	 * @param index 第几个指针
	 * @param value 指针的值
	 */
	public void setPseudoPointer(int index, int value)
	{
		pseudoPointer[index] = value;
	}
	
	/**
	 * 获取伪指针
	 * @param index 下标
	 * @return 伪指针的值
	 */
	public int getPseudoPointer(int index)
	{
		if (index < 0 || index >= pseudoPointer.length)
			throw new NullPointerException("伪指针不存在");
		return pseudoPointer[index];
	}
	
	public void setContent(E content)
	{
		this.content = content;
	}
	
	public E getContent()
	{
		return this.content;
	}
}

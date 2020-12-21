package dataStructure.tree.pseudoPointerTree;
/**
 * 伪指针树节点
 * @author BlazingPhoenix<br>
 * @map 图示<br>
 * ——————————————	<br>
 *|   content    |  数据部分<br>
 * ——————————————	<br>
 *|pseudoPointer0|  伪指针列表部分<br>
 * --------------	<br>
 *|pseudoPointer1|	<br>
 *----------------	<br>
 * pseudoPointer n	<br>
 */
public class TreeNode<E> {
	//数据
	private E content;
	//伪指针列表
	private int[] pseudoPointer;
	
	/**
	 * 构造方法
	 * @param bifurcation
	 */
	public TreeNode(int bifurcation)
	{
		pseudoPointer = new int[bifurcation];
		for (int i = 0; i < bifurcation; i ++)
		{
			pseudoPointer[i] = -1;
		}
	}
	
	/**
	 * 构造方法
	 * @param content
	 * @param bifurcation
	 */
	public TreeNode(E content, int bifurcation)
	{
		this.content = content;
		pseudoPointer = new int[bifurcation];
		for (int i = 0; i < bifurcation; i ++)
		{
			pseudoPointer[i] = -1;
		}
	}
	
	public void setContent(E content)
	{
		this.content = content;
	}
	
	public E getContent()
	{
		return this.content;
	}
	
	/**
	 * 设置伪指针
	 * @param index 伪指针在列表中的下标
	 * @param value 伪指针的值
	 */
	public void setPointer(int index, int value)
	{
		/*if (index < 0 || index >= pseudoPointer.length)
			return;*/							/**@Exception 抛出异常**/
		pseudoPointer[index] = value;
	}
	
	/**
	 * 获取伪指针
	 * @param index 伪指针在列表中的下标
	 * @return 伪指针的值
	 */
	public int getPointer(int index)
	{
		/*if (index < 0 || index >= pseudoPointer.length)
			return -1;*/							/**@Exception 抛出异常**/
		return pseudoPointer[index];
	}
	
}

package dataStructure.tree;
/**
 * 完全二叉树二叉树
 * @author BlazingPhoenix
 * @param <E> 内容
 */
public class CompletBinaryTree<E> {

	//内容
	private E content;
	//左子树
	private CompletBinaryTree left;
	//右子树
	private CompletBinaryTree right;
	
	/**
	 * 构造方法
	 * @param content 内容
	 */
	public CompletBinaryTree(E content)
	{
		this.content = content;
	}
	
	/**
	 * 无参构造方法
	 */
	public CompletBinaryTree()
	{
		
	}
	
	/**
	 * 设置二叉树的内容
	 * @param content 内容
	 */
	public void setContent(E content)
	{
		this.content = content;
	}
	
	/**
	 * 获取二叉树的内容
	 * @return 内容
	 */
	public E getContent()
	{
		return this.content;
	}
	
	/**
	 * 设置左子树
	 * @param left 左子树
	 */
	private void setLeft(CompletBinaryTree left)
	{
		this.left = left;
	}
	
	/**
	 * 设置右子树
	 * @param right 右子树
	 */
	private void setRight(CompletBinaryTree right)
	{
		this.right = right;
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public CompletBinaryTree getLeft()
	{
		return this.left;
	}
	
	/**
	 * 获取右子树
	 * @return 右子树
	 */
	public CompletBinaryTree getRight()
	{
		return this.right;
	}
	
	/**
	 * 判断左子树是否为空
	 * @return 左子树为空返回true
	 */
	public boolean leftIsEmpty()
	{
		return this.left == null;
	}
	
	/**
	 * 判断右子树是否为空
	 * @return 右子树为空返回true
	 */
	public boolean rightIsEmpty()
	{
		return this.right == null;
	}
	
	public void add(CompletBinaryTree tree)
	{
		
	}
}

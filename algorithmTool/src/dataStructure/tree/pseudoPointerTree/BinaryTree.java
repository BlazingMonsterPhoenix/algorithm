package dataStructure.tree.pseudoPointerTree;
/**
 * 伪指针二叉树
 * @author BlazingPhoenix
 * @optimization 待优化点：<br>
 * 				 setLeft和setRight方法,如果set一个较大的树<br>
 * 				   容易出现StackOverflowError问题,原因是递归层数过多，方法栈溢出<br>
 * 				   优化方法：<br>
 * 				   尝试改作循环
 * @param <E> 二叉树节点内存储的数据
 */
public class BinaryTree<E> extends AbstractNaryTree<E>{

	/**
	 * 无参构造方法
	 * @description 实例化对象，设置树的分叉数为2
	 */
	public BinaryTree() {
		super(2);
	}
	
	/**
	 * 构造方法
	 * @description 设置树的分叉数为2<br>
	 * 				设置根节点的内容
	 */
	public BinaryTree(E content) {
		super(2);
		setContent(content);
	}

	@Override
	protected BinaryTree<E> getSubTree(int index) {
		BinaryTree<E> subTree = new BinaryTree<E>();
		subTree.parasitize(this);
		subTree.root = branch.createSubIfSubIsNull(this.root, index);
		return subTree;
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public BinaryTree<E> getLeft()
	{
		return this.getSubTree(0);
	}
	
	/**
	 * 获取右子树
	 * @return 右子树
	 */
	public BinaryTree<E> getRight()
	{
		return this.getSubTree(1);
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setLeft(BinaryTree<E> tree)
	{
		BinaryTree<E> leftTree = getLeft();
		if (leftTree.isEmpty() && tree.isEmpty())
		{
			return;
		}
		leftTree.setContent(tree.getContent());
		if (!leftTree.isEmpty())
		{
			leftTree.setLeft(tree.getLeft());
			leftTree.setRight(tree.getRight());
		}
	}
	
	/**
	 * 设置右子树
	 * @param tree 右子树
	 */
	public void setRight(BinaryTree<E> tree)
	{
		BinaryTree<E> rightTree = getRight();
		if (rightTree.isEmpty() && tree.isEmpty())
		{
			return;
		}
		rightTree.setContent(tree.getContent());
		if (!rightTree.isEmpty())
		{
			rightTree.setLeft(tree.getLeft());
			rightTree.setRight(tree.getRight());
		}
	}
	
}

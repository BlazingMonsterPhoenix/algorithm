package dataStructure.tree.pseudoPointerTree;

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
	 * @deprecated 存在bug，待检查
	 */
	private void setLeft(BinaryTree<E> tree)
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
	 * @deprecated 存在bug，待检查
	 */
	private void setRight(BinaryTree<E> tree)
	{
		BinaryTree<E> rightTree = getLeft();
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

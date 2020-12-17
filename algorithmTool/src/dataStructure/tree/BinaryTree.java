package dataStructure.tree;

/**
 * 二叉树
 * @author BlazingPhoenix
 * 
 * @param <E> 存储的数据的类型
 */
public class BinaryTree<E> extends AbstractNaryTree<E> {
	
	/**
	 * 无参构造方法
	 */
	public BinaryTree()
	{
		super();
		//分叉数
		bifurcation = 2;
		//初始化二叉树数据
		branch = new Branch();
	}
	
	/**
	 * 新建二叉树并创建根节点
	 * @param root 根节点的内容（数据）
	 */
	public BinaryTree(E root)
	{
		super();
		//分叉数
		bifurcation = 2;
		//初始化二叉树数据
		branch = new Branch();
		branch.set(0, root);
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public BinaryTree<E> getLeft()
	{
		if (root * 2 > branch.getSize() || branch.get(root * 2 - 1) == null) {
			return new BinaryTree<E>();
		}
		BinaryTree<E> subLeftTree = new BinaryTree<E>();
		subLeftTree.parasitize(this);
		subLeftTree.root = this.root * 2;
		return subLeftTree;
	}
	
	/**
	 * 获取右子数
	 * @return 右子树
	 */
	public BinaryTree<E> getRight()
	{
		if (root * 2 + 1 > branch.getSize() || branch.get(root * 2) == null) {
			return new BinaryTree<E>();
		}
		BinaryTree<E> subRightTree = new BinaryTree<E>();
		subRightTree.parasitize(this);
		subRightTree.root = this.root * 2 + 1;
		return subRightTree;
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setLeft(BinaryTree<E> tree)
	{
		//设置的左子树为空且当前树的左子树为空
		if (tree.isEmpty() && this.getLeft().isEmpty())
		{
			return;
		}
		else
		{
			//设置左孩子节点的内容
			E content = tree.branch.get(tree.root - 1);
			this.branch.set(root * 2 - 1, content);
			//设置左孩子节点的左右子树
			BinaryTree<E> subLeftTree = this.getLeft();
			subLeftTree.setLeft(tree.getLeft());
			subLeftTree.setRight(tree.getRight());
		}
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setRight(BinaryTree<E> tree)
	{
		//设置的右子树为空且当前树的右子树为空
		if (tree.isEmpty() && this.getRight().isEmpty())
		{
			return;
		}
		else
		{
			//设置右孩子节点的内容
			E content = tree.branch.get(tree.root - 1);
			this.branch.set(root * 2, content);
			//设置右孩子节点的左右子树
			BinaryTree<E> subLeftTree = this.getRight();
			subLeftTree.setLeft(tree.getLeft());
			subLeftTree.setRight(tree.getRight());
		}
	}
	
}

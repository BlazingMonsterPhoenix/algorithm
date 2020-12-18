package dataStructure.tree.arrayTree;

/**
 * 二叉树
 * @author BlazingPhoenix
 * 
 * @param <E> 存储的数据的类型
 */
public class ArrayBinaryTree<E> extends AbstractArrayNaryTree<E> {
	
	/**
	 * 无参构造方法
	 */
	public ArrayBinaryTree()
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
	public ArrayBinaryTree(E root)
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
	public ArrayBinaryTree<E> getLeft()
	{
		if (root * 2 > branch.getSize()) {
			return new ArrayBinaryTree<E>();
		}
		ArrayBinaryTree<E> subLeftTree = new ArrayBinaryTree<E>();
		subLeftTree.parasitize(this);
		subLeftTree.root = this.root * 2;
		return subLeftTree;
	}
	
	/**
	 * 获取右子数
	 * @return 右子树
	 */
	public ArrayBinaryTree<E> getRight()
	{
		if (root * 2 + 1 > branch.getSize()) {
			return new ArrayBinaryTree<E>();
		}
		ArrayBinaryTree<E> subRightTree = new ArrayBinaryTree<E>();
		subRightTree.parasitize(this);
		subRightTree.root = this.root * 2 + 1;
		return subRightTree;
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setLeft(ArrayBinaryTree<E> tree)
	{
		//设置的左子树为空且当前树的左子树为空
		if (tree.isEmpty() && this.getLeft().isEmpty())
		{
			return;
		}
		else
		{
			ArrayBinaryTree<E> subLeftTree = this.getLeft();
			//设置左孩子节点的内容
			E content = tree.getContent();
			subLeftTree.setContent(content);
			//this.branch.set(root * 2 - 1, content);
			//设置左孩子节点的左右子树
			subLeftTree.setLeft(tree.getLeft());
			subLeftTree.setRight(tree.getRight());
		}
	}
	
	/**
	 * 设置右子树
	 * @param tree 右子树
	 */
	public void setRight(ArrayBinaryTree<E> tree)
	{
		//设置的右子树为空且当前树的右子树为空
		if (tree.isEmpty() && this.getRight().isEmpty())
		{
			return;
		}
		else
		{
			ArrayBinaryTree<E> subRightTree = this.getRight();
			//设置右孩子节点的内容
			E content = tree.getContent();
			subRightTree.setContent(content);
			//this.branch.set(root * 2, content);
			//设置右孩子节点的左右子树
			subRightTree.setLeft(tree.getLeft());
			subRightTree.setRight(tree.getRight());
		}
	}
	
}

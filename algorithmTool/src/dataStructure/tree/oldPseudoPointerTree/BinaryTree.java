package dataStructure.tree.oldPseudoPointerTree;

import dataStructure.tree.arrayTree.ArrayBinaryTree;

public class BinaryTree<E> extends AbstractNaryTree<E> {

	/**
	 * 无参构造方法
	 */
	public BinaryTree() {
		super(2);
	}
	
	public BinaryTree(E content)
	{
		super(2);
		TreeNode<E> rootNode = new TreeNode<E>(content);
		getBranch().set(rootNode);
	}
	
	public void printPointList()
	{
		for (int i = 0; i < 2; i ++)
		{
			int pointerList = this.getPointer(i);
			System.out.println(pointerList);
		}
	}
	
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public BinaryTree<E> getLeft()
	{
		int leftTreeRoot = this.getPointer(0);
		//返回空树
		if (leftTreeRoot >= getBranch().getFlag() || leftTreeRoot < 0) {
			//判断左指针，若果为空则初始化
			leftTreeRoot = leftTreeRoot >= 0 ? leftTreeRoot : getBranch().getFlag();
			this.setPointer(0, leftTreeRoot);
		}
		BinaryTree<E> subLeftTree = new BinaryTree<E>();
		subLeftTree.parasitize(this);			
		//左子树的根等于当前节点的左伪指针指向的区域
		subLeftTree.root = leftTreeRoot;
		return subLeftTree;
	}
	
	/**
	 * 获取右子树
	 * @return 右子树
	 */
	public BinaryTree<E> getRight()
	{
		int rightTreeRoot = this.getPointer(1);
		//返回空树
		if (rightTreeRoot >= getBranch().getFlag() || rightTreeRoot < 0) {
			//判断右指针，若果为空则初始化
			rightTreeRoot = rightTreeRoot >= 0 ? rightTreeRoot : getBranch().getFlag();
			this.setPointer(0, rightTreeRoot);
		}
		BinaryTree<E> subRightTree = new BinaryTree<E>();
		subRightTree.parasitize(this);			
		//左子树的根等于当前节点的左伪指针指向的区域
		subRightTree.root = rightTreeRoot;
		return subRightTree;
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setLeft(BinaryTree<E> tree)
	{
		if (this.isEmpty())
		{
			return;				/**@Exception 抛异常*/
		}
		//设置的左子树为空且当前树的左子树为空
		if (tree.isEmpty() && this.getLeft().isEmpty())
		{
			return;
		}
		else
		{
			//获取左子树
			BinaryTree<E> subLeftTree = this.getLeft();
			//设置左孩子节点的内容
			E content = tree.getContent();
			subLeftTree.setContent(content);
			//设置左孩子节点的左右子树
			subLeftTree.setLeft(tree.getLeft());
			subLeftTree.setRight(tree.getRight());
		}
	}
	
	/**
	 * 设置右子树
	 * @param tree 右子树
	 */
	public void setRight(BinaryTree<E> tree)
	{
		if (this.isEmpty())
		{
			return;				/**@Exception 抛异常*/
		}
		//设置的右子树为空且当前树的右子树为空
		if (tree.isEmpty() && this.getRight().isEmpty())
		{
			return;
		}
		else
		{
			//获取右子树
			BinaryTree<E> subRightTree = this.getRight();
			//设置右孩子节点的内容
			E content = tree.getContent();
			subRightTree.setContent(content);		/**bug**/
			
			//设置右孩子节点的左右子树
			subRightTree.setLeft(tree.getLeft());
			subRightTree.setRight(tree.getRight());
		}
	}

}
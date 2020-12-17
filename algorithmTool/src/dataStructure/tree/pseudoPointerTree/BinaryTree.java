package dataStructure.tree.pseudoPointerTree;

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
		branch.set(rootNode);
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public BinaryTree<E> getLeft()
	{
		//返回空树
		if (root * 2 > branch.getSize() || branch.get(root * 2 - 1) == null) {
			return new BinaryTree<E>();
		}
		BinaryTree<E> subLeftTree = new BinaryTree<E>();
		subLeftTree.parasitize(this);
		//左子树的根等于当前节点的左伪指针指向的区域
		subLeftTree.root = branch.get(root).getPseudoPointer(0);
		return subLeftTree;
	}

}

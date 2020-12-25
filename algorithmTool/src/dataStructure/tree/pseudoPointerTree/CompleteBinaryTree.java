package dataStructure.tree.pseudoPointerTree;

/**
 * 伪指针完全二叉树
 * @author BlazingPhoenix
 *
 */
public class CompleteBinaryTree<E> extends AbstractNaryTree<E>{

	/**
	 * 无参构造方法
	 */
	public CompleteBinaryTree() {
		super(2);
	}
	
	/**
	 * 构造方法
	 * @description 初始化一个完全二叉树，并设置根节点内容
	 * @param content 根节点的内容
	 */
	public CompleteBinaryTree(E content) {
		super(2);
		setContent(content);
	}

	@Override
	protected CompleteBinaryTree<E> getSubTree(int index) {
		if (index < 0 || index > 1)
			return new CompleteBinaryTree<E>();				/**@Exception 抛出异常**/
		CompleteBinaryTree<E> subTree = new CompleteBinaryTree<E>();
		subTree.parasitize(this);
		subTree.root = (this.root + 1) * 2 - 1 + index;
		return subTree;
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public CompleteBinaryTree<E> getLeft()
	{
		return this.getSubTree(0);
	}
	
	/**
	 * 获取右子树
	 * @return 右子树
	 */
	public CompleteBinaryTree<E> getRight()
	{
		return this.getSubTree(1);
	}
	
	/**
	 * 释放最后一个节点并返回它的内容
	 * @return 最后一个节点的内容
	 */
	public E pushLasteNode()
	{
		int laste = branch.getSize();
		E content = branch.getContent(laste);
		branch.deleteSize();
		//获取父节点在数组中的下标
		int fatherRoot = ((laste + 1) / 2) - 1;
		//获取指针列表下标，当前节点为父节点的左孩子节点，下标为0，否则为1
		int index = (laste + 1) % 2;
		//释放指针
		branch.setPoint(fatherRoot, index, -1);
		return content;
	}
	
	/**
	 * 获取最后一个节点
	 * @return 根节点为当前树的最后一个节点的完全二叉树
	 */
	public CompleteBinaryTree<E> getLasteNode()
	{
		CompleteBinaryTree<E> subTree = new CompleteBinaryTree<E>();
		subTree.parasitize(this);
		subTree.root = this.branch.getSize() - 1;
		return subTree;
	}
	
	/**
	 * 增加节点
	 * @description 按照完全二叉树的规则增加节点，并设置节点的内容
	 * @param content 节点的内容
	 */
	public void addNode(E content)
	{
		int subRoot = this.branch.getSize();
		//将节点的父节点的指针指向节点
		//获取父节点在数组中的下标
		int fatherRoot = ((subRoot + 1) / 2) - 1;
		//获取指针列表下标，当前节点为父节点的左孩子节点，下标为0，否则为1
		int index = (subRoot + 1) % 2;
		//创建节点
		int returnSubRoot = branch.createSubIfSubIsNull(fatherRoot, index);
		if (subRoot != returnSubRoot)
		{
			return;						/**@Exception 抛出异常**/
		}
		branch.setContent(content, returnSubRoot);
	}
	
	public int getSize()
	{
		return branch.getSize();
	}
	

}

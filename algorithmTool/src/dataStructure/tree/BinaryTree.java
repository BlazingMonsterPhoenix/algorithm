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
		tree = new Branch();
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
		tree = new Branch();
		tree.set(0, root);
	}
	
	/**
	 * 判断当前树是否为空
	 * @return 若是则返回true
	 */
	public boolean isEmpty()
	{
		return tree.get(root) == null;
	}
	
	/**
	 * 修改当前树的内容（数据）
	 * @param content 内容
	 */
	public void setContent(E content)
	{
		tree.set(root, content);
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public BinaryTree getLeft()
	{
		if (root * 2 < tree.getSize()) {
			return null;
		}
		BinaryTree subLeftTree = new BinaryTree();
		subLeftTree.parasitize(this);
		subLeftTree.root = this.root * 2;
		return subLeftTree;
	}
	
	/**
	 * 获取右子数
	 * @return 右子树
	 */
	public BinaryTree getRight()
	{
		if (root * 2 + 1 < tree.getSize()) {
			return null;
		}
		BinaryTree subLeftTree = new BinaryTree();
		subLeftTree.parasitize(this);
		subLeftTree.root = this.root * 2 + 1;
		return subLeftTree;
	}
}

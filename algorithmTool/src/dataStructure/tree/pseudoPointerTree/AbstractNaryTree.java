package dataStructure.tree.pseudoPointerTree;


/**
 * 伪指针n叉树抽象类
 * @author BlazingPhoenix
 * @description 所有伪指针n叉树的父类（指针古树）<br>
 * 				底层用一维数组实现，查找速度较快<br>
 * 				解决了线性n叉树层数多后OOM的问题
 * @param <E>
 */
public abstract class AbstractNaryTree<E> {
	
	//枝条
	private Branch<E> branch;
	//分叉数
	private int bifurcation;
	//当前正在操作的树的根节点，在整棵树中的下标值+1
	protected int root;
	
	/**
	 * 构造方法
	 * @param bifurcation 分叉数
	 */
	public AbstractNaryTree(int bifurcation)
	{
		this.bifurcation = bifurcation;
		this.root = 0;
		branch = new Branch(bifurcation);
	}
	
	
	/**
	 * 判断树是否为空
	 * @return 若树为空则返回true
	 */
	public boolean isEmpty()
	{
		return branch.isEmpty(root);
	}
	
	/**
	 * 设置树节点的内容
	 * @param content 树节点的内容
	 */
	public void setContent(E content)
	{
		branch.setContent(content, root);
	}
	
	/**
	 * 获取树节点的内容
	 * @return 内容
	 */
	public E getContent()
	{
		return branch.getContent(root);
	}
	
	/**
	 * 设置当前树节点的指定伪指针
	 * @param index 伪指针在伪指针列表中的下标
	 * @param value 伪指针的值
	 */
	protected void setPoint(int index, int value)
	{
		branch.setPoint(root, index, value);
	}
	
	/**
	 * 获取当前树的指定伪指针
	 * @param index 伪指针在伪指针列表中的下标
	 * @return 伪指针的值
	 */
	protected int getPoint(int index)
	{
		return branch.getPoint(root, index);
	}
	
	/**
	 * 寄生
	 * @description 使自身的数据与另一棵树的相同<br>
	 * 				且自身的数据改变和它的数据改变会互相影响<br>
	 * 				（寄生于另一棵树）
	 * @param anotherTree 另一棵树
	 */
	protected void parasitize(AbstractNaryTree<E> anotherTree)
	{
		this.branch = anotherTree.branch;
	}
	
	/**
	 * 创建当前树的子树，若子树未实例化
	 * @description 根据当前树的伪指针查找指定的子树，如果未实例化，则实例化。<br>
	 * 				返回子树节点在branch中的下标
	 * @param index 指向子树的伪指针在指针列表中的下标
	 * @return 子树节点在branch中的下标
	 */
	protected int createSubIfSubIsNull(int index)
	{
		return branch.createSubIfSubIsNull(root, index);
	}
	
	/**
	 * 获取子树
	 * @description 根据当前树的伪指针查找指定的子树节点<br>
	 * 				如果子树节点未实例化，则实例化。<br>
	 * 				返回子树<br>
	 * 				抽象方法，需要子类实现
	 * @param index 指向子树的伪指针在指针列表中的下标
	 * @return 子树
	 */
	protected abstract AbstractNaryTree<E> getSubTree(int index);
	/*protected AbstractNaryTree<E> getSubTree(int index)
	{
		AbstractNaryTree<E> subTree = new AbstractNaryTree<E>(bifurcation);
		subTree.parasitize(this);
		subTree.root = branch.createSubIfSubIsNull(root, index);
		return subTree;
	}*/
	
}

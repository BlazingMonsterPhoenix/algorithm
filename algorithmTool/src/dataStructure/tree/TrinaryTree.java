package dataStructure.tree;

import algorithmTool.math.mathTools.MathTool;

/**
 * 三叉树
 * @author BlazingPhoenix
 */
public class TrinaryTree {
	
	private Object content;			//内容
	private TrinaryTree left;		//左子树
	private TrinaryTree right;		//右子树
	private TrinaryTree middle;		//中子树
	
	/**
	 * 获取节点内容
	 * @return 节点的内容
	 */
	public Object getContent()
	{
		return this.content;
	}
	
	/**
	 * 获取左子树
	 * @return 左子树
	 */
	public TrinaryTree getLeft()
	{
		return this.left;
	}
	
	/**
	 * 获取右子树
	 * @return 右子树
	 */
	public TrinaryTree getRight()
	{
		return this.right;
	}
	
	/**
	 * 获取中子树
	 * @return 中子树
	 */
	public TrinaryTree getMiddle()
	{
		return this.middle;
	}
	
	/**
	 * 设置左子树
	 * @param tree 左子树
	 */
	public void setLeft(TrinaryTree tree)
	{
		this.left = tree;
	}
	
	/**
	 * 设置右子树
	 * @param tree 右子树
	 */
	public void setRight(TrinaryTree tree)
	{
		this.right = tree;
	}
	
	/**
	 * 设置中子树
	 * @param tree 中子树
	 */
	public void setMiddle(TrinaryTree tree)
	{
		this.middle = tree;
	}
	
	/**
	 * 比较两个三叉树的内容
	 * @description 将自身的内容与另一个三叉树的内容进行比较<br>
	 * 				若自身的内容大于另一个三叉树的内容，返回1<br>
	 * 				若小于另一个三叉树的内容，返回-1，相等返回0<br>
	 * 				若三叉树的内容不属于基本类型的封装类或BigDecimal，则报异常
	 * @param tree 参与比较的另一个三叉树
	 * @return 比较结果
	 */
	public int compareTo(TrinaryTree tree)
	{
		return MathTool.compare(content, tree.getContent());
	}
	
	/**
	 * 在当前节点上增加一个三叉树
	 * @description 增加逻辑：三叉树左子树比父节点小<br>
	 * 				右子树比父节点大，中子树与父节点相等
	 * @param tree 增加的三叉树
	 */
	public void add(TrinaryTree tree)
	{
		TrinaryTree flag = this;
		if (compareTo(tree) == 0)		
		{
			while (flag.getMiddle() != null)
				flag = flag.getMiddle();
			flag.setMiddle(tree);
		}
		else if (compareTo(tree) == 1)
		{
			if (flag.getRight() == null)
				flag.setRight(tree);
			else
				flag.getRight().add(tree);
		}
		else
		{
			if (flag.getLeft() == null)
				flag.setLeft(tree);
			else
				flag.getLeft().add(tree);
		}
	}
	
	/**
	 * object构造方法
	 * @param content 内容
	 */
	public TrinaryTree(Object content)
	{
		setContent(content);
	}
	
	/**
	 * byte构造方法
	 * @param content 内容
	 */
	public TrinaryTree(byte content)
	{
		setContent(content);
	}
	
	/**
	 * short构造方法
	 * @param content 内容
	 */
	public TrinaryTree(short content)
	{
		setContent(content);
	}
	
	/**
	 * int构造方法
	 * @param content 内容
	 */
	public TrinaryTree(int content)
	{
		setContent(content);
	}
	
	/**
	 * long构造方法
	 * @param content 内容
	 */
	public TrinaryTree(long content)
	{
		setContent(content);
	}
	
	/**
	 * float构造方法
	 * @param content 内容
	 */
	public TrinaryTree(float content)
	{
		setContent(content);
	}
	
	/**
	 * double构造方法
	 * @param content 内容
	 */
	public TrinaryTree(double content)
	{
		setContent(content);
	}
	
	/**
	 * char构造方法
	 * @param content 内容
	 */
	public TrinaryTree(char content)
	{
		setContent(content);
	}
	
	private void setContent(Object content)
	{
		this.content = content;
	}
	
	private void setContent(byte content)
	{
		this.content = new Byte(content);
	}
	
	private void setContent(short content)
	{
		this.content = new Short(content);
	}
	
	private void setContent(int content)
	{
		this.content = new Integer(content);
	}
	
	private void setContent(long content)
	{
		this.content = new Long(content);
	}
	
	private void setContent(float content)
	{
		this.content = new Float(content);
	}
	
	private void setContent(double content)
	{
		this.content = new Double(content);
	}
	
	private void setContent(char content)
	{
		this.content = new Character(content);
	}
}

package algorithmTool.main;

import java.util.ArrayList;
import java.util.List;

import dataStructure.tree.arrayTree.ArrayBinaryTree;
import dataStructure.tree.pseudoPointerTree.AbstractNaryTree;
import dataStructure.tree.pseudoPointerTree.BinaryTree;
import dataStructure.tree.pseudoPointerTree.CompleteBinaryTree;
import algorithmTool.arrayTools.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.auxiliaryTools.ArrayReorderTool;
import algorithmTool.arrayTools.auxiliaryTools.ConversionTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.arrayTools.searcher.ModeSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;
import algorithmTool.math.mathTools.MathTool;

////////////////////////////////////////////////////////////////////
//					  _ooOoo_                               //
//					 o8888888o                              //
//					 88" . "88                              //
//					 (| ^_^ |)                              //
//					 O\  =  /O                              //
//				  ____/`---'\____                           //
//				.'  \\|     |//  `.                         //
//			   /  \\|||  :  |||//  \                        //
//			  /  _||||| -:- |||||-  \                       //
//			  |   | \\\  -  /// |   |                       //
//			  | \_|  ''\---/''  |   |                       //
//			  \  .-\__  `-`  ___/-. /                       //
//			___`. .'  /--.--\  `. . ___                     //
//		  ."" '<  `.___\_<|>_/___.'  >'"".                  //
//		| | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//		\  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//========`-.____`-.___\_____/___.-`____.-'========         //
//`=---='                              //
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//		佛祖保佑       永无BUG     	    一次测通     抢到红包				    //
////
////////////////////////////////////////////////////////////////////
public class Main {

	public static void main(String[] args) {
		
		/*CompleteBinaryTree<Integer> root = new CompleteBinaryTree<Integer>(1);
		for (int i = 2; i < 11; i ++)
		{
			root.addNode(i);
		}
		System.out.println(root.getContent());
		System.out.println(root.getLeft().getContent());
		System.out.println(root.getRight().getContent());
		System.out.println(root.getLeft().getLeft().getContent());
		System.out.println(root.getLeft().getRight().getContent());
		System.out.println(root.getRight().getLeft().getContent());
		System.out.println(root.getRight().getRight().getContent());
		/*BinaryTree<Integer> root = new BinaryTree<Integer>(5);
		
		BinaryTree<Integer> leftTree = new BinaryTree<Integer>(2);
		leftTree.setRight(new BinaryTree<Integer>(3));
		leftTree.setLeft(new BinaryTree<Integer>(1));
		root.setLeft(leftTree);
		
		BinaryTree<Integer> rightTree = new BinaryTree<Integer>(6);
		rightTree.setRight(new BinaryTree<Integer>(8));
		root.setRight(rightTree);
		
		System.out.println(root.getContent());
		System.out.println(root.getLeft().getContent());
		System.out.println(root.getLeft().getLeft().getContent());
		System.out.println(root.getLeft().getRight().getContent());
		System.out.println(root.getRight().getContent());
		System.out.println(root.getRight().getRight().getContent());*/
		
		
		/*BinaryTree<Integer> root = new BinaryTree<Integer>();
		root.setContent(5);
		BinaryTree<Integer> left = new BinaryTree<Integer>(5);
		BinaryTree<Integer> tree = left;
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000; i ++)
		{
			tree.setLeft(new BinaryTree<Integer>(6));
			tree.setRight(new BinaryTree<Integer>(6));
			tree = tree.getLeft();
		}
		
		
		//root.setLeft(left);
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - startTime) + "毫秒");*/
		//System.out.println(root.getLeft().getLeft().getContent());
		//System.out.println(root.getLeft().getLeft().getLeft().getContent());
		//System.out.println(Math.pow(2, 27));
	}
	
}

/**
* 　　　　　　　　┏┓　　　┏┓+ +
* 　　　　　　　┏┛┻━━━┛┻┓ + +
* 　　　　　　　┃　　　　　　　┃
* 　　　　　　　┃　　　━　　　┃ ++ + + +
* 　　　　　　     ████━████┃+
* 　　　　　　　┃　　　　　　　┃ +
* 　　　　　　　┃　　　┻　　　┃
* 　　　　　　　┃　　　　　　　┃ + +
* 　　　　　　　┗━┓　　　┏━┛
* 　　　　　　　　　┃　　　┃
* 　　　　　　　　　┃　　　┃ + + + +
* 　　　　　　　　　┃　　　┃　　　　 Code is far away from bug with the animal protecting
* 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无 bug
* 　　　　　　　　　┃　　　┃
* 　　　　　　　　　┃　　　┃　　+
* 　　　　　　　　　┃　 　　┗━━━┓ + +
* 　　　　　　　　　┃ 　　　　　　　┣┓
* 　　　　　　　　　┃ 　　　　　　　┏┛
* 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
* 　　　　　　　　　　┃┫┫　┃┫┫
* 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
*/
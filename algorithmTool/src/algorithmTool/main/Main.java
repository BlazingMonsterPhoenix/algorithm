package algorithmTool.main;

import java.util.ArrayList;
import java.util.List;

import dataStructure.tree.BinaryTree;
import algorithmTool.arrayTools.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.auxiliaryTools.ArrayReorderTool;
import algorithmTool.arrayTools.auxiliaryTools.ConversionTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.arrayTools.searcher.ModeSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;
import algorithmTool.math.mathTools.MathTool;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree<Integer> root = new BinaryTree<Integer>();
		root.setContent(5);
		
		BinaryTree<Integer> leftTree = new BinaryTree<Integer>(2);
		leftTree.setLeft(new BinaryTree<Integer>(1));
		leftTree.setRight(new BinaryTree<Integer>(3));
		root.setLeft(leftTree);
		
		BinaryTree<Integer> rightTree = new BinaryTree<Integer>(6);
		rightTree.setRight(new BinaryTree<Integer>(8));
		root.setRight(rightTree);
		
		System.out.println(root.getContent());
		System.out.println(root.getLeft().getContent());
		System.out.println(root.getLeft().getLeft().getContent());
		System.out.println(root.getLeft().getRight().getContent());
		System.out.println(root.getRight().getContent());
		System.out.println(root.getRight().getRight().getContent());
		
	}
	
}

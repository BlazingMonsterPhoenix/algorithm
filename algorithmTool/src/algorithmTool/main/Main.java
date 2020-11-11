package algorithmTool.main;

import javax.xml.ws.Response;

import dataStructure.tree.TrinaryTree;
import algorithmTool.arrayTools.Sortor.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.reorderTool.ArrayReorderTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;

public class Main {

	public static void main(String[] args) {
		Integer a = new Integer(100);
		TrinaryTree tree = new TrinaryTree(a);
		++ a;
		System.out.println(a);
		System.out.println(tree.getContent());
	}
	
}

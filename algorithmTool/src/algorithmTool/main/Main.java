package algorithmTool.main;

import algorithmTool.arrayTools.Sortor.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.reorderTool.ArrayReorderTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;

public class Main {

	public static void main(String[] args) {
		int a[] = new int[]{10,5,6,4,3,9,7,8,2,0};
		AbstractSortor s = new ShellSortor(a);
		Object[] ia = s.sort();
		for (int i = 0; i < ia.length; i ++)
			System.out.println(ia[i]);
	}
	
}

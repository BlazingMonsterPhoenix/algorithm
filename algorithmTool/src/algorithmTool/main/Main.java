package algorithmTool.main;

import algorithmTool.arrayTools.Sortor.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.conversionTool.ConversionTool;
import algorithmTool.arrayTools.reorderTool.ArrayReorderTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;
import algorithmTool.math.mathTools.MathTool;

public class Main {

	public static void main(String[] args) {
		int a[] = new int[10000];
		for (int i = 0; i < a.length; i ++)
			a[i] = i + 1;
		Integer b[] = ConversionTool.ObjectArrayOf(a);
		ArrayReorderTool.disaster(b);
		AbstractSortor shellS = new ShellSortor(b);
	}
	
}

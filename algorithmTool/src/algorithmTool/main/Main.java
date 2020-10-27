package algorithmTool.main;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import algorithmTool.arrayTool.abstractSortor.AbstractIntSortor;
import algorithmTool.arrayTool.intSortor.*;
import algorithmTool.arrayTools.reorderTool.IntArrayReorderTool;
import algorithmTool.arrayTools.searcher.IntArrayElementSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;

public class Main {

	public static void main(String[] args) {
		Character c = new Character('b');
		BigDecimal ret = null;
		if (c instanceof Character)
		{
			ret = new BigDecimal((Character)c);
		}
		System.out.println(ret);
	}
	
	public String judgeType(Object temp) {
        if (temp instanceof Byte) {
            return "是Byte类型";
        } else if (temp instanceof Integer) {
            return "是Integer类型";
        } else {
            return "是其他类型";
        }
    }
	
}

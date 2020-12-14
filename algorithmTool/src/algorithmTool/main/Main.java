package algorithmTool.main;

import java.util.ArrayList;
import java.util.List;

import algorithmTool.arrayTools.Sortor.*;
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
		/*int time = 0;
		for (int t = 0; t < 50; t ++)
		{*/
			int a[] = new int[100];
			for (int i = 0; i < a.length; i ++)
			{
				a[i] = i % 99;
			}
			Object b[] = ArrayReorderTool.disaster(ConversionTool.ObjectArrayOf(a));
			long startTime = System.currentTimeMillis();
			List<Object> modeList = ModeSearcher.search(b);
			long endTime = System.currentTimeMillis();
			for (int i = 0; i < modeList.size(); i ++)
				System.out.println(modeList.get(i));
			//System.out.println("升级版计数法找众数所花时间为：" + (endTime - startTime) + "毫秒");
			//time += (endTime - startTime);
		//}
		//System.out.println("\n\n升级版计数法找众数平均所花时间为：" + time / 50 + "毫秒");
	}
	
}

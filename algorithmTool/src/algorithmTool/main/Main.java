package algorithmTool.main;

import java.util.List;

import algorithmTool.arrayTools.Sortor.*;
import algorithmTool.arrayTools.abstractSortor.AbstractSortor;
import algorithmTool.arrayTools.conversionTool.ConversionTool;
import algorithmTool.arrayTools.reorderTool.ArrayReorderTool;
import algorithmTool.arrayTools.searcher.ArrayElementSearcher;
import algorithmTool.arrayTools.searcher.ModeSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;
import algorithmTool.math.mathTools.MathTool;

public class Main {

	public static void main(String[] args) {
		int time = 0;
		for (int t = 0; t < 50; t ++)
		{
			/**准备阶段**/
			int a[] = new int[2000000];
			for (int i = 0; i < a.length; i ++)
			{
				a[i] = (int)(Math.random() * 6);
			}
			Integer b[] = ConversionTool.ObjectArrayOf(a);
			/**测试**/
			long startTime = System.currentTimeMillis();
			List<Object> modeList = ModeSearcher.searchByEntrucking(b,6);
			long endTime = System.currentTimeMillis();
			time += endTime - startTime;
			System.out.println("装车法找众数方法所用时间：" + (endTime - startTime) + "毫秒");
			
			/*startTime = System.currentTimeMillis();
			modeList = ModeSearcher.searchByEntrucking(b, 6);
			//List<Object> modeList = ModeSearcher.searchBySorting(b);
			//new MergeSortor().sort(b);
			endTime = System.currentTimeMillis();
			time += endTime - startTime;
			System.out.println("装车法找众数方法所用时间：" + (endTime - startTime) + "毫秒");*/
			
		}
		System.out.println("\n装车法平均使用时间为" + time / 50);
	}
	
}

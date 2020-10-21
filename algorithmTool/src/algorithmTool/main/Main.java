package algorithmTool.main;

import java.util.ArrayDeque;

import algorithmTool.arrayTool.abstractSortor.AbstractIntSortor;
import algorithmTool.arrayTool.intSortor.*;
import algorithmTool.arrayTools.reorderTool.IntArrayReorderTool;
import algorithmTool.arrayTools.searcher.IntArrayElementSearcher;
import algorithmTool.formula.caculator.Calculator;
import algorithmTool.formula.exception.FormulaException;

public class Main {

	public static void main(String[] args) {
		/*int a[] = new int[20];
		for (int i = 0; i < a.length; i ++)
		{
			a[i] = i + 1;
		}*/
		
	}
	
	
	/*Calculator calculator = new Calculator();
	try {
		System.out.println(calculator.calculate("1+2*(--.2)/-0.1"));
	} catch (FormulaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
	/*AbstractSortor s = new BubbleSortor();
	int a[] = new int[] {5,4,9,1,3,8,2,6,7,0};
	a = s.sort(a);*/
	/*
	 * int a[] = new int[54];
		for (int i = 0; i < 54; i ++)
			a[i] = i + 1;
		ArrayTool.disaster(a);
		for (int i = 0; i < 54; i ++)
		{
			if (a[i] < 53) 
				a[i] = a[i] % 13 + 1;
		}
		new MergeSortor().sort(a, 0, 17);
		new MergeSortor().sort(a, 18, 35);
		new MergeSortor().sort(a, 36, 53);
		for (int i = 0; i < a.length; i ++)
		{
			if (i % 18 == 0 && i != 0)
				System.out.println();
			if (a[i] == 53)
				System.out.print("小王 ");
			else if (a[i] == 54)
				System.out.print("大王 ");
			else
				System.out.print(a[i] + " ");
		}
	 */
}

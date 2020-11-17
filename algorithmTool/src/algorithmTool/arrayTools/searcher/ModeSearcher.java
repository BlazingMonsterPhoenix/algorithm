package algorithmTool.arrayTools.searcher;

import java.util.ArrayList;
import java.util.List;
import dataStructure.tree.TrinaryTree;

/**
 * 众数搜索类
 * @author BlazingPhoenix
 *
 */
public class ModeSearcher {
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static List searchByTrinaryTree(Object[] array)
	{
		TrinaryTree tree = new TrinaryTree(array[0]);
		for (int i = 1; i < array.length; i ++)
			tree.add(new TrinaryTree(array[i]));
		return getModeList(tree);
	}
	
	
	private static List getModeList(TrinaryTree tree)
	{
		List<Object> mode = new ArrayList<Object>();
		int maxDepth = tree.getDepthOfMiddle();
		mode.add(tree.getContent());
		return mode;
	}
	
	
	
	
	
	
	
}

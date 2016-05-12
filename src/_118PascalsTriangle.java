import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月12日下午3:52:32 
 * @todo:TODO
 */
public class _118PascalsTriangle {
	public static void main(String[] args) {
		int num = 1;
		List<List<Integer>> list = generate(num);
		System.out.println(list.toString());
	}
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (0 == numRows) return lists;
        
        ArrayList<Integer> list0 = new ArrayList<Integer>();
        list0.add(0, 1);
        lists.add(0, list0);
        
        for (int i = 1; i < numRows; i++) {
        	int num = i + 1;
			ArrayList<Integer> temp = new ArrayList<Integer>(num);
			for (int j = 0; j < num; j++) {
				temp.add(j, -1);
			}
			ArrayList<Integer> pre = (ArrayList<Integer>) lists.get(i - 1);
			temp.set(0, pre.get(0));
			temp.set(i, pre.get(i-1));
			for (int j = 1; j < i; j++) 
				temp.set(j, pre.get(j-1)+pre.get(j));
			
			lists.add(temp);
		}
        return lists;
    }
}

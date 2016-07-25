import java.util.Arrays;
import java.util.List;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年7月25日下午10:40:20 
 * @todo:Given an index k, return the kth row of the Pascal's triangle.
 */
public class _119PascalsTriangle02 {
	public List<Integer> getRow(int rowIndex){
		Integer[] rowList = new Integer[rowIndex + 1];
		rowList[0] = 1;
		for (int i = 1; i < rowList.length; i++) {
			rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
		}
		return Arrays.asList(rowList);
	}
}

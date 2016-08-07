import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年6月14日下午9:08:30 
 * @todo:TODO
 */
public class _350IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
        	if (nums1[i] < nums2[i]) i++;
        	else if (nums2[i] < nums1[i]) j++;
        	else {
				temp.add(nums1[i]);
				i++;j++;
			}
        }
        int[] arr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
			arr[i] = temp.get(i);
		}
        return arr;
    }
}

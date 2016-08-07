import java.util.HashSet;
import java.util.Set;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年8月7日上午11:03:23 
 * @todo:Given two arrays, write a function to compute their intersection.
 * 只是说计算交集
 */
public class _349IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2){
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> intersect = new HashSet<Integer>();
		
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		
		int[] result = new int[intersect.size()];
		int i = 0;
		for (int a : intersect) {
			result[i++] = a;
		}
		
		return result;
	}
}
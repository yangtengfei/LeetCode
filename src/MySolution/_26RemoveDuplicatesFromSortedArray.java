package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年6月25日下午9:03:39 
 * @todo:TODO
 */
public class _26RemoveDuplicatesFromSortedArray {	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(removeDuplicates(nums));
	}
	public static int removeDuplicates(int[] nums) {
		if (2 > nums.length) return nums.length;
		int len = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i+1]) {
				nums[len] = nums[i+1];
				len ++;
			}
		}
		return len;
    }
}

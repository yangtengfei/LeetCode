package MySolution;
import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that 
 * duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * @author yangtf3
 *
 */
public class _80RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));
	}
    public static int removeDuplicates(int[] nums) {
    	if (nums.length < 3) {
			return nums.length;
		}
    	int len = 2;
    	for (int i = 2; i < nums.length; i++) {
			/*if (nums[i] == nums[len - 1]) {
				if (nums[len - 1] == nums[len - 2]) {
					continue;
				}else {
					nums[len++] = nums[i];
				} 
			}else {
				nums[len++] = nums[i];
			}*/
    		if (nums[i] != nums[len - 2]) { // 参考2号算法，由上面注释部分的代码优化而来
				nums[len++] = nums[i];
			}
		}
		return len;
    }
    
    public static int removeDuplicates2(int[] nums) {
    	int i = 0;
    	for (int n : nums) {
			if (i < 2 || n != nums[i - 2]) {
				nums[i] = n;
				i += 1;
			}
		}
    	return i;
    }
}

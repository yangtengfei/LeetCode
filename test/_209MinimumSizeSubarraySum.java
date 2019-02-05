
/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 *  If there isn't one, return 0 instead.
 * @author yangtf3
 *  双索引技术 ---- 滑动窗口
 */
public class _209MinimumSizeSubarraySum {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}
	
    public static int minSubArrayLen(int s, int[] nums) {
    	if (nums.length == 0 || nums == null) {
			return 0;
		}
    	// window
    	int l = 0, r = -1, len = nums.length + 1, tempSum = 0; // [l,r]
    	while (l < nums.length) {
			if (tempSum < s) {
				r++;
				if (r == nums.length) { // 此处出错，这时没有进行判断，r长到数组的长度后就不长了。 tempSum won't grow up
					break;
				}
				tempSum += nums[r]; // 一旦用方括号取值，就要小心数组越界的问题。
			}else {
				len = (r - l + 1) > len ? len : (r - l + 1);
				tempSum -= nums[l++];
			}
		}
    	if (len == nums.length + 1) {
			return 0;
		}
        return len;
    }
}

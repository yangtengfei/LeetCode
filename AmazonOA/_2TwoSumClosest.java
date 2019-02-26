import java.util.Arrays;

public class _2TwoSumClosest {
	public int twoSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 2 || target < 0) {
			return -1;
		}
		Arrays.sort(nums);
		
		int left = 0, right = nums.length - 1, differ = Integer.MAX_VALUE;
		while (left < right) {
			if (nums[right] - nums[left] == target) {
				 return 0;
			}else if (nums[right] + nums[left] > target) {
				differ = Math.min(differ, nums[right] + nums[left] - target);
				right--;
			}else {
				differ = Math.min(differ, target - (nums[right] + nums[left]));
				left++;
			}
		}
		return differ;
	}
}

package MySolution;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * return [0, 1].
 * 
 * @author yangtengfei
 */
public class _1TwoSum {
	public int[] twoSum(int[] nums, int target){
		int[] arr1 = new int[nums.length];
		for(int i = 0; i < nums.length - 1; i++){
			int num1 = nums[i];
			for(int j = i + 1; j < nums.length; j++){
				int num2 = nums[j];
				if(num1 + num2 == target){
					// 往数组arr1 添加数据
				}
			}
		}
		return arr1;
	}
}

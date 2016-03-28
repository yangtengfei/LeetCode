package MySolution;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * */
public class _169MajorityElement {
	public int majorityElement(int[] nums){
		int temp = nums[0], flag = 1;
		for (int i = 1; i < nums.length; i++) {
			if (flag == 0) {
				temp = nums[i];
			}
			if (temp == nums[i]) {
				flag ++;
			}else {
				flag --;
			}
		}
		return temp;
	}
}

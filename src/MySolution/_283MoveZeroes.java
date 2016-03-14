package MySolution;

/**
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * @author yangtf
 *
 */
public class _283MoveZeroes {
	public void moveZeroes(int[] nums){
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j ++;
			}
		}
		for (int i = j; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}

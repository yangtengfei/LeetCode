package MySolution;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * @author yangtf
 * 相似题目：27、26、80
 */
public class _283MoveZeroes {
	// 我的
	public static void moveZeroes(int[] nums){
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
	
	// 在时间上进一步优化，采用交换的方式
	public static void moveZeroes2(int[] nums){
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}
	
	// 针对特殊测试用例进一步优化
	public static void moveZeroes3(int[] nums){
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (i != j) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					j++;
				}
				j++;
			}
		}
	}
	
	public static void main(String[] args) { 
		int arr[] = {0, 1, 0, 3, 12};
		moveZeroes2(arr);
		System.out.println(Arrays.toString(arr));

	}
}

package MySolution;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年6月25日下午9:03:39 
 * @todo:TODO
 */
public class _26RemoveDuplicatesFromSortedArray {	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates3(nums));
		System.out.println(Arrays.toString(nums));
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
	
	// 一个数和它前面的数比较
	public static int removeDuplicates2(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[len++] = nums[i];
			}
		}
		return len;
    }
	
	// 一个数和维护数组的最后一个值比较
	public static int removeDuplicates3(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[len - 1]) {
				nums[len++] = nums[i];
			}
		}
		return len;
    }
}

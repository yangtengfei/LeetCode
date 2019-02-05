/**
 * 在未排序的数组中找到第 k个最大的元素。请注意，你需要找的是数组排序后的第 k个最大的元素，而不是第 k个不同的元素。
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author yangtf3
 * 尚未完成
 */
public class _215KthLargestElementInAnArray {
	public static void main(String[] args) {
		 int[] arr = {3,2,1,5,6,4};
		 int k = 2;
		 System.out.println(findKthLargest(arr, k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, k, 0, nums.length - 1);
    }

	private static int findKthLargest(int[] nums, int k, int start, int end) {
		int flag = start, i = start + 1, j = end;
		while (i < j) { // [i,j] [3,4,2,5,2,4]
			while (nums[j] > nums[flag]) j--;
			swap(nums, flag, j);
			flag = j;
			while (nums[i] < nums[flag]) i++;
			swap(nums, flag, i);
			flag = i;
		}
		if (flag + k == nums.length) {
			return nums[flag];
		}else if (flag + k < nums.length) {
			return findKthLargest(nums, k, flag, nums.length - 1);
		}else {
			return findKthLargest(nums, k, 0, flag); 
		}
	}

	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}

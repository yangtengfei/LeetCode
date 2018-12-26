package MySolution;
import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 假设 nums1 有足够的空间
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @author yangtf3
 *
 */
public class _88MergeSortedArray {
	public static void main(String[] args) {
		int[] arr1 = {0}, arr2 = {1};
		int m = 0, n = 1;
		merge(arr1, m, arr2, n);
		System.out.println(Arrays.toString(arr1));
	}
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int flag = nums1.length - 1, i = m - 1, j = n - 1;
    	for(; i > -1 && j > -1;) {
    		nums1[flag--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    	}
    	for(;j > -1; j--) {
			nums1[j] = nums2[j];
		}
    }
}

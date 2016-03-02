public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 9, 10, 10, 11 };
		int[] nums2 = { 4, 5, 6, 7, 8 };

		double medNum = findMedianSortedArrays(nums1, nums2);
		System.out.println(medNum);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
		// 如果总长度为奇数
		if (sumLen % 2 != 0) {
			return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
		} else { // 总长度为偶数
			// 寻找第k小的数 和 第 k+1 小的数，平均后为中位数
			return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2) + findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
		}
	}
	
	private static int findKthSmallest(int[] nums1, int len1, int begin1, int[] nums2, int len2, int begin2, int k) {
		if (len1 > len2) // 将len1设置为最短的数组
			return findKthSmallest(nums2, len2, begin2, nums1, len1, begin1, k);
		if (len1 == 0)
			return nums2[begin2 + k - 1];
		if (k == 1)
			return Integer.min(nums1[begin1], nums2[begin2]);
		
		int partA = Integer.min(k / 2, len1), partB = k - partA;
		
		if (nums1[begin1 + partA - 1] == nums2[begin2 + partB - 1]) 
			return nums1[begin1 + partA - 1];
		
		else if (nums1[begin1 + partA - 1] > nums2[begin2 + partB - 1])
			// 为什么 len2-partB
			return findKthSmallest(nums1, len1, begin1, nums2, len2 - partB, begin2 + partB, k - partB);
		
		else
			return findKthSmallest(nums1, len1 - partA, begin1 + partA, nums2, len2, begin2, k - partA);
	}
}

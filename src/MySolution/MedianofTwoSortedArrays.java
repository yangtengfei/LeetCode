package MySolution;

/**
 * 看了答案之后自己写了一遍
 * @author yangtf
 *
 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,1};
		int[] nums2 = {1,2};
		
		double medNum = findMedianSortedArrays(nums1, nums2);
		System.out.println(medNum);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, numlen = len1 + len2;
		if (numlen % 2 != 0) { // 奇数直接找中间值
			return findKth(nums1, len1, 0, nums2, len2, 0, numlen / 2 + 1);
		} else { // 偶数 找中间的两个值 求平均
			return (findKth(nums1, len1, 0 ,nums2, len2, 0, numlen / 2) + findKth(nums1, len1, 0, nums2, len2, 0, numlen / 2 +1)) / 2;
		}
	}

	// begin的意思是从原数组中开始的位置，len的意思是原数组还剩下的数组的长度
	private static int findKth(int[] nums1, int len1, int begin1, int[] nums2, int len2, int begin2, int k) {
		if (len1 > len2) { // 将 len1 设置为最短的数组
			findKth(nums2, len2, begin2, nums1, len1, begin1, k);
		}
		if (len1 == 0) { // n 次迭代后 某一个长度变为0，则去另一个的值
			return nums2[begin2 + k - 1];
		}
		if (k == 1) { // 若 k = 1，则只剩下两个值比较，返回最小值
			return Integer.min(nums1[begin1], nums2[begin2]);
		}
		
		int partA = Integer.min(k / 2, len1), partB = k - partA;
		
		if (nums1[begin1 + partA - 1] == nums2[begin2 + partB - 1]) {
			return nums1[begin1 + partA - 1];
		}
		if (nums1[begin1 + partA - 1] > nums2[begin2 + partB - 1]) {
			return findKth(nums1, len1, begin1, nums2, len2 - partB, begin2 + partB, k - partB);
		}else {
			return findKth(nums1, len1 - partA, begin1 + partA, nums2, len2, begin2, k - partA);
		}
	}
}

	
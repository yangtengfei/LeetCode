package other;

public class BinarySearch {
	public int binarySearch(int[] arr, int n, int target) {
		int l = 0, r = n - 1; // 在[l...r]的范围寻找target
		while(l < r) {
			int mid = l + (r - l)/2; // 取中间点，为了防止l+r溢出，所以采用此方法。 l+r>n,l+(r-l)/2<n
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				r = mid - 1;
			}else {
				l = mid + 1;
			}
		}
		return -1;
	}
}

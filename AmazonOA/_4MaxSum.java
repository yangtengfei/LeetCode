
public class _4MaxSum {
	public static void main(String[] args) {
		int[] arr = {0, 6, -1, 1, -6, 7, -5};
		System.out.println(getMaxSum(arr));
	}
	
	public static int getMaxSum(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		
		int maxSum = 0, tempSum = 0;
		for (int i : array) {
			tempSum += i;
			maxSum = maxSum < tempSum ? tempSum : maxSum;
			tempSum = tempSum == 0 ? 0: tempSum;
		}
		
		return maxSum;
	}
}
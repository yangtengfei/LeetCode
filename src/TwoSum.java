
public class TwoSum {

	public static void main(String[] args) {
		int[] aums  = {3,2,4};
		int target = 6;
	    int[] res = twoSum(aums,target);
	    for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	// 得到两个索引
	private static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j =i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i + 1;
					res[1] = j + 1;
				}
			}
		}
		return res;
	}

}

package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年7月24日下午10:39:46
 * @todo:TODO
 */
public class _136SingleNumber {
	public int singleNumber(int[] nums) {
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			int b = nums[i];
			a = a ^ b;
		}
		return a;
	}
}

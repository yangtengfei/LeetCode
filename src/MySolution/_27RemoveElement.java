package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月8日下午4:06:11 
 * @todo:TODO
 */
public class _27RemoveElement {
	public static void main(String[] args) {
		int[] a = {3,2,2,3};
		System.out.println(removeElement(a, 3));
	}
	public static int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				continue;
			}
			nums[flag] = nums[i];
			flag ++;
		}
        return flag;
    }
}

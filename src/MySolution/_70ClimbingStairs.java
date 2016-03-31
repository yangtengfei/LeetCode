package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年3月31日下午5:09:15 
 * @todo:You are climbing a stair case. It takes n steps to reach to the top.
 * 		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class _70ClimbingStairs {
	public int climbStairs(int n) {
        int[] array = new int[n+1];
        
        if (n < 3) {
			return n;
		}
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
        return array[n];
    }
}

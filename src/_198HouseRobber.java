/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月6日上午9:41:24 
 * @todo:You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * 这个问题可以用dp的思想来考虑， 对于第n个房间我们所能有的选择是偷和不偷，
 * 那么如果是做决定是偷 则上一步必须是不偷 那么 这一步的就是 dp[N] = num[i -1 ] + dpNonTake[N -1] , 
 * 假设dp[N] 表示的是有N个元素时候的最大值状态。 如果是不偷， 那么上一步就无所谓是不是已经偷过，
 * 所以就copy为 dp[N] = dp[N -1 ]即可，所以总而言之为 dp[N] = Math.max(dpNontake[N-1 ] + num【i】, dp[N-1] );
 *  因为每一轮迭代只需要触碰到dp 的相邻两个选项 所以可以空间压缩为 两个元素即可。
 * 一个 为take 一个为 nontake 和 到当前的最大值。 那么迭代为：
 * take = nonTake + num【i】;  偷
 * nonTake = maxProfit;    不偷 
 * maxProfit = Math.max(take,nonTake); 求最大利润
 */
public class _198HouseRobber {
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,5};
		int max = rob(arr);
		System.out.println(max);
	}
	public static int rob(int[] nums){
		int take = 0;
		int maxProfit = 0;
		int nonTake = 0;
		for (int i = 0; i < nums.length; i++) {
			take = nonTake + nums[i];
			nonTake = maxProfit;
			maxProfit = Math.max(take, nonTake);
		}
		return maxProfit;
	}
}

package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月10日上午10:10:56 
 * @todo:Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock)
 * design an algorithm to find the maximum profit.
 */
public class _121BestTimetoBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int maxProfix = 0,point = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[point] < prices[i] && prices[i] - prices[point] > maxProfix)maxProfix = prices[i] - prices[point];
			if (prices[point] > prices[i])point = i;		
		}
        return maxProfix;
    }
}

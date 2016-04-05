package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月5日下午9:11:35 
 * @todo:TODO
 */
public class _326PowerOfThree {
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(243));
	}
	
	/**
	 * 之前用 log 不行，换成 log10 就可以了，log10 返回以10为底的结果
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree(int n) {
		return Math.log10(n)/Math.log10(3) % 1 == 0 ? true : false;
    }
}

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年7月17日下午5:37:01 
 * @todo:TODO
 */
public class _371SumofTwoIntegers {
	public static void main(String[] args) {
		getSum(9,3);
	}
	
	public static int getSum(int a, int b){
		if (b == 0) return a;
		
		int sum, carry;
		sum = a ^ b;
		System.out.println(sum);
		carry = (a & b) << 1;
		System.out.println(carry);
		return getSum(sum, carry);
	}
}

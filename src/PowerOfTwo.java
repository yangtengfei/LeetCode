
/**
 * Given an integer, write a function to determine if it is a power of two.
 * 判断一个整数是否是2的幂
 * @author yangtf
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
//		if (isPowerOfTwo(Integer.parseInt(args[0]))) {
		if (isPowerOfTwo(4)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	private static boolean isPowerOfTwo(int n) {
		 return n < 1 ? false : (n & (n - 1)) == 0 ? true : false;
	}

}

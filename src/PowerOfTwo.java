
/**
 * Given an integer, write a function to determine if it is a power of two.
 * 判断一个整数是否是2的幂
 * @author yangtf
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
//		if (isPowerOfTwo(Integer.parseInt(args[0]))) {
		if (isPowerOfTwo(-11)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	private static boolean isPowerOfTwo(int n) {
		if (1 == n) {
			return true;
		}
		int remainder = 0;	// 余数
		int result = n;		// 商
		while (0 == remainder && 0 < result) {
			remainder = result%2;
			result = result/2;
			if (0 == remainder && 1 == result) {
				return true;
			}
		}
		return false;
	}

}

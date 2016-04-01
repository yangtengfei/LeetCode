/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月1日下午6:04:33
 * @todo:TODO
 */
public class _202HappyNumber {
	static int i = 8;

	public static void main(String[] args) {
		System.out.println(isHappy(i));
	}

	public static boolean isHappy(int n) {
		int x = n;
		int y = n;
		while (x > 1) {
			x = cal(x);
			if (x == 1)
				return true;
			y = cal(cal(y));
			if (y == 1)
				return true;

			if (x == y)
				return false;
		}
		return true;
	}

	public static int cal(int n) {
		int x = n;
		int s = 0;
		while (x > 0) {
			s = s + (x % 10) * (x % 10);
			x = x / 10;
		}
		return s;
	}
}

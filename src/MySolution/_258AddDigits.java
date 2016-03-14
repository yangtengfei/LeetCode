package MySolution;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example：
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * 看了维基百科的提示了
 * @author yangtf
 *
 */
public class _258AddDigits {
	public int addDigits(int num){
		if (num < 10) {
			return num;
		}
		return (num - 9 * (int)((num - 1)/ 9));
	}
}

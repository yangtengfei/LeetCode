package MySolution;

/**
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

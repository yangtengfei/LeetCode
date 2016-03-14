package MySolution;

/**
 * 找到规律即可，不能是4的倍数
 * @author yangtf
 *
 */
public class _292NimGame {
	public boolean canWinNim(int n){
		if (n % 4 == 0) {
			return false;
		}else {
			return true;
		}
	}
}

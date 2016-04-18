/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月18日上午8:50:34 
 * @todo:Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 */
public class _342PowerOfFour {
	public boolean isPowerOfFour(int num) {
        for (int i = -1; i < 15; i++) {
			if (num == (1 << ((i+1) * 2))) return true;
		}
        return false;
    }
}

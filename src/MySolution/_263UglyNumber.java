package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月3日上午9:57:57 
 * @todo:Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 */
public class _263UglyNumber {
	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
        if(num == 1 || num == 2 || num == 3 || num == 5){
        	return true;
        }
        if (num % 5 == 0) {
			return isUgly(num / 5);
		}else if (num % 2 == 0) {
			return isUgly(num / 2);
		}else if (num % 3 == 0) {
			return isUgly(num / 3);
		}else {
			return false;
		}
    }
}

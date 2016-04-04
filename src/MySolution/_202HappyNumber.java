package MySolution;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月4日上午9:40:47 
 * @todo:自己的解决方案----之前面百度被问到了这个题，总是问我为什么会陷入一个循环，我答的不好
 */
public class _202HappyNumber {
	
	public static void main(String[] args) {
		int num = 2;
		System.out.println(isHappy(num));
	}
	
	public static boolean isHappy(int n) {
		int num = 0;
		int flag = n;
		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			while (true) {
				if (flag / 10 > 0) {
					int i = flag % 10;
					num += i * i;
					flag = flag / 10;
				}else {
					num += flag * flag;
					break;
				}
			}
	        if (num == 1) {
				return true;
			}else if (list.contains(num)) {
				return false;
			}else {
				list.add(num);
				flag = num;
				num = 0;
			}
		}
    }
}

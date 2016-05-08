package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月5日上午10:15:38
 * @todo:Write a function that takes a string as input and returns the string
 *             reversed.
 */
public class _344ReverseString {
	public static void main(String[] args) {
		String string = "asdasf123";
		System.out.println(reverseString(string));
	}
	public static String reverseString(String s) {
		char[] c = s.toCharArray();
		StringBuilder str = new StringBuilder();
		for(int i = c.length-1; i >= 0; i --){
			str.append(String.valueOf(c[i]));
		}
		return str.toString();
	}
}

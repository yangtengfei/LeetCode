/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月5日上午10:15:38
 * @todo:Write a function that takes a string as input and returns the string
 *             reversed.
 */
public class _344ReverseString {
	public static void main(String[] args) {
		String string = "";
		System.out.println(reverseString(string));
	}
	public static String reverseString(String s) {
		char[] c = s.toCharArray();
		String str = "";
		for(int i = c.length-1; i >= 0; i --){
			str += c[i];
		}
		return str;
	}
}

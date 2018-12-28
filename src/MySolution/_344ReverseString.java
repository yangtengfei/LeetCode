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
	
	// 最新的对撞指针，刚好能看到成长
    public static String reverseString2(String s) {
    	if (s == null || s.length() == 0) {
			return s;
		}
    	char[] charS = s.toCharArray();
    	int i = 0, j = charS.length - 1;
    	while (i < j) { // [i,j]
			char temp = charS[i];
			charS[i++] = charS[j];
			charS[j--] = temp;
		}
    	return String.valueOf(charS);
    }
}

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
		/*char[] c = s.toCharArray();
		String str = "";
		for(int i = c.length-1; i >= 0; i --){
			str += c[i];
		}
		return str;*/
		char[] c = s.toCharArray();
        for (int i=0,j=c.length-1;i<j;i++,j--){
            char temp = c[i];
            c[i]=c[j];
            c[j]=temp;
        }
        return new String(c);
	}
}

package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月9日下午7:46:00
 * @todo:Write a function that takes a string as input and reverse only the
 *             vowels(元音) of a string.
 *             2 优化
 */
public class _345ReverseVowelsOfaString {
	public static void main(String[] args) {
		String s = "ai";
		System.out.println(reverseVowels2(s));
	}
	public static String reverseVowels(String s) {
		char[] a = s.toCharArray();
		int i = 0, j = a.length-1;
		
		while (i < j) {
			if (contains(a[i])) {
				while (i < j) {
					if (contains(a[j])) {
						char temp = a[i];
						a[i] = a[j];
						a[j] = temp;
						j--;
						break;
					}
					j--;
				}
			}
			i++;
		}
		
		return new String(a);
	}
	
	private static boolean contains(char c){
		char[] aa = {'a','e','i','o','u','A','E','I','O','U'};
		for (char d : aa) {
			if (d == c) return true;
		}
		return false;
	}
	
    public static String reverseVowels2(String s) {
    	if (s == null || s.length() == 0) {
			return s;
		}
    	char[] charS = s.toCharArray();
    	int i = 0, j = charS.length - 1;
    	while (i < j) {
			while (i != j && !isVowels(charS[i])) { // 这里相等的判断优化了
				i++;
			}
			while (i != j && !isVowels(charS[j])) {
				j--;
			}
			char temp = charS[i];
			charS[i++] = charS[j];
			charS[j--] = temp;
		}
        return String.valueOf(charS);
    }
	private static boolean isVowels(char c) { // 可优化
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
			c == 'A' || c == 'E' || c == 'i' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}
}

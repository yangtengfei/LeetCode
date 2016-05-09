package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月9日下午7:46:00
 * @todo:Write a function that takes a string as input and reverse only the
 *             vowels of a string.
 */
public class _345ReverseVowelsOfaString {
	public static void main(String[] args) {
		String s = "race car";
		System.out.println(reverseVowels(s));
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
	
	public static boolean contains(char c){
		char[] aa = {'a','e','i','o','u','A','E','I','O','U'};
		for (char d : aa) {
			if (d == c) return true;
		}
		return false;
	}
}

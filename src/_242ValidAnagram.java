import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s. 判断t是否的s的变位词
 * 
 * @author yangtf
 *
 */
public class _242ValidAnagram {
	public boolean isAnagram(String s, String t) {
		char v1[] = map(s);
		char v2[] = map(t);
		return Arrays.equals(v1, v2);
	}

	private char[] map(String s) {
		char[] map = new char[128];
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			map[c] += 1; 
		}
 		return map;
	}
}

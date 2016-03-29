import java.util.HashMap;
import java.util.Map;


/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）
 * @author yangtf
 *
 */
public class _13RomanToInteger {
	
	public static void main(String[] args) {
		String s = "D";
		int r = romanToInt(s);
		System.out.println(r);
	}
	
	public static int romanToInt(String s){
		if (s == null || 0 == s.length()) return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int len = s.length();
		int result = map.get(s.charAt(len - 1));
		int point = result;

		for(int i =len - 2; i >= 0; i --){
			int curr = map.get(s.charAt(i));
			if (point > curr) {
				result -= curr;
			} else {
				result += curr;
			}
			point = curr;
		}
		return result;
	}
}

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Given a string S, 
// find the length of the longest substring T that contains at most k distinct characters.

// ** 两个版本 len=k or 没有这个要求 **

// 自己还是能想出思路并大致码出代码的
// 目前的问题是 边界问题处理的不好，还有就是没有考虑清楚maxLen的增加和map大小判断的位置。

public class _386LongestSubstringWithAtMostKDistinctCharacters {
	public static void main(String[] args) {
		// String string = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
		String s = "aabccc";
		int k = 1;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
/*		int n = s.length();
		if (n <= k) {
			return n;
		}
		int left = 0, right = 0;
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		int maxLen = k;
		while (right < n) {
			if (hashMap.size() <= k) {
				hashMap.put(s.charAt(right), right++);
			}
			if (hashMap.size() > k) {
				int index = Collections.min(hashMap.values());
				hashMap.remove(s.charAt(index));
				left = index + 1;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;*/
		
		// check
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		
		// init
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArr = s.toCharArray();
		int i = 0, j = 0;
		
		// lenth
		while(j <= s.length()-1) {
			Integer num1 = map.get(charArr[j]);
			if (num1 == null) {
				num1 = 0;
			}
			map.put(charArr[j], num1 + 1);
			maxLen = maxLen > (j - i + 1) ? maxLen : (j-i+1);
			j++; // 在这里，每一次循环j都会++，难道不应该是等到map的size合适之后，j再走？
			if (map.size() > k) {
				int num2 = map.get(charArr[i]);
				num2--;
				if (num2 == 0) {
					map.remove(charArr[i]);
				}else {
					map.put(charArr[i], num2);
				}
				i++;
				maxLen--;
			}
		}
		
       return maxLen;
    }
}

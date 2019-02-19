package self;

import java.util.HashMap;
import java.util.Map;

//Given a string S, 
//find the length of the longest substring T that contains at most k distinct characters.

public class _386 {
	// 没有 len=k 的限制
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		// check 
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		if (s.length() <= k) {
			return s.length();
		}
		
		// init
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0, j = 0;
		
		// loop
		while (j < s.length()) {
			Integer temp = map.get(s.charAt(j));
			if (temp == null) {
				temp = 0;
			}
			map.put(s.charAt(j), temp++);
			if (map.size() <= k) {
				if ((j - i + 1) > maxLen) {
					maxLen = j - i + 1;
				}
			}
			if (map.size() > k) {
				Integer temp2 = map.get(s.charAt(i));
				temp2--;
				if (temp2 == 0) {
					map.remove(s.charAt(i));
				}else {
					map.put(s.charAt(i), temp2);
				}
				i++;
			}else {
				
			}
			j++; // 这里j一直++的原因想清楚了：如果有大于maxLen的长度，那么i一定会停下来。这里是与之前的maxLen比较。
/*			if (map.size() <= k) {
				Integer num = map.get(s.charAt(j));
				if (num == null) {
					num = 0;
				}
				map.put(s.charAt(j), ++num);
				if ((j-i+1) > maxLen) {
					maxLen = j - i + 1;
				}
				j++;
			}else {
				Integer num = map.get(s.charAt(i));
				num--;
				if (num == 0) {
					map.remove(s.charAt(i));
				}else {
					map.put(s.charAt(i), num);
				}
				i++;
			}*/
		}
		
		return maxLen;
	}
	
	// 有最长为K的限制
	// Given a string and number K, find the substrings of size K with K distinct characters. 
	// If no, output empty list. Remember to emit the duplicate substrings, i.e. if the substring repeated twice, only output once.
	public int lengthOfLongestSubstringKDistinctAndSizeSmallerThanK(String s, int k) {
		// 没有平台可以验证，思路：定义一个数据结构，包含字符、位置，用map保存,key为字符，插入前先获取，如果已经保存了，则将左指针移到位置上，这样节省时间
		return 0;
	}
}

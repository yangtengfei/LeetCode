import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not
 *  be larger than 20,100.
 *  The order of output does not matter.
 *  Input:
 *  s: "cbaebabacd" p: "abc"
 *  Output:
 *  [0, 6]
 *  Explanation:
 *  The substring with start index = 0 is "cba", which is an anagram of "abc".
 *  The substring with start index = 6 is "bac", which is an anagram of "abc".
 *  两个字符串的比较：比较大小，或比较内容。 1.14 没想好
 * @author yangtf3
 *
 */
public class _438FindAllAnagramsInAString {
	public static void main(String[] args) {
		String string = "cbaebabacd";
		String pString = "abc";
		System.out.println(findAnagrams(string, pString).toString());
	}
	
    public static List<Integer> findAnagrams(String s, String p) {
    	// 验空
        if (s == null || s.length() == 0) return null;     
        
        // 数据初始化
        List<Integer> list = new ArrayList<Integer>();
        int[] map = new int[256]; // 匹配字符
        for (int i = 0; i < p.length(); i++) map[p.charAt(i)] += 1;
        int l = 0, r = 0; // 窗口
        int count = p.length(); // 未匹配字符数量
        
        // cbaebabacd
        while (r < s.length()) {
			if (map[s.charAt(r)] >= 1) {
				count--;
			}
			map[s.charAt(r)]--;
			r++;
			if (count == 0) {
				list.add(l);
			}
			if (r-l == p.length()) {
				if (s.charAt(l) >= 0) {
					map[s.charAt(l)]++;	
					count++;
				}
				l++;
			}
		}
        return list;
    }
}
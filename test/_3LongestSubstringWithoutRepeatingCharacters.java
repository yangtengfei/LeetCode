/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * @author yangtf3
 * 438 \ 76
 *  滑动窗口
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String string = null;
		System.out.println(lengthOfLongestSubstring(string));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	if (s == null) {
			return 0;
		}
    	int[] freq = new int[256]; // freq['b'] = 2; 可以这样赋值
     	int l = 0, r = 0, estLen = 0;
    	
    	while (l < s.length()) {
			if (r < s.length() && freq[s.charAt(r)] == 0) {
				freq[s.charAt(r)] = 1;
				estLen = Math.max(estLen, r - l + 1);
				r++;
			}else {
				freq[s.charAt(l)] = 0;
				l++;
			}
			
		}
        return estLen;
    }
}

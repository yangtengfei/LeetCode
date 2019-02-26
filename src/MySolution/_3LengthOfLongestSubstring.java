package MySolution;

import java.util.Arrays;

public class _3LengthOfLongestSubstring {
	public static void main(String[] args) {
		String string = "abba";
		System.out.println(lengthOfLongestSubstring(string));
	}
    public static int lengthOfLongestSubstring(String s) {   
        // check
        if(s == null || s.length() == 0) return -1;
        
        // initial 
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        int l = 0, r = 0, res = 0;
        
        while(r < s.length()){
        	if(freq[s.charAt(r)] != -1) l = Math.max(l, freq[s.charAt(r)] + 1);
            freq[s.charAt(r)] = r++;
            res = Math.max(res, r - l);
        }
        
        return res;
    }
}

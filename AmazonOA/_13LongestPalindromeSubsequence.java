public class _13LongestPalindromeSubsequence {
	public String longestPalindromeSubsequence(String s) {
		if(s == null || s.length() == 0) return s;
		
		int start = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l -1;
	}
}

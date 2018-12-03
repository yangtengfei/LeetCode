package MySolution;
public class _28ImplementStrstr {

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "a";
		int flag = strStr(str1,str2);
		System.out.println(flag);
	}
	
	public static int strStr(String haystack, String needle){
		if(needle.length() == 0) return 0;
		if(haystack.length() == 0 || haystack.length() < needle.length()) return -1;
		int i;
		for(i = 0; i <= haystack.length()-1; i++){
			for(int j = 0; j <= needle.length()-1; j++){
			    if(i+j == haystack.length()) return -1;
				if(haystack.charAt(i+j) != needle.charAt(j)){
					j = 0;
					break;
				} 
				if(j == needle.length() - 1) return i;
			}
		}
		return -1;
	}

}

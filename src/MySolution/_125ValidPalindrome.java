package MySolution;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @author yangtf3
 *
 */
public class _125ValidPalindrome {
	public static void main(String[] args) {
		String string = ",.";
		System.out.println(isPalindrome(string));
	}
    public static boolean isPalindrome(String s) {
    	if (s == null) { // null的验证，不知道toLowerCase是否可传入null，测试了一下
			return true;
		}
        s = s.toLowerCase(); // 转换成同样的大小写，总想着有更好的方法不用转化，所以迟迟没有动手
        char[] charS = s.toCharArray();
        int i = 0, j = charS.length - 1; // 对撞指针
        while (i < j) {
			while (!isRightChar(charS[i])) { 
				i++; // 考虑的不全面，没有考虑到全不是字母或数字的情况
				if (i == j) return true;
			}
			while (!isRightChar(charS[j])) {
				j--;
				if (i == j) return true;
			}
			if (charS[i] != charS[j]) return false;
			i++; // 只剩一个字符时，i j 相等，跳出循环
			j--;
		}
        
        return true;
    }
    
    // 参考其它人的，觉得抽象出一个方法验证更好
	private static boolean isRightChar(char c) {
		if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) { // char的验证 可以用 = > < 等，验证的字符需要加''
			return true;
		}
		return false;
	}
}

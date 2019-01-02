package MySolution;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author yangtf3
 *
 */
public class _17LetterCombinationsofAPhoneNumber {
	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		String nums = "23";
		System.out.println(letterCombinations3(nums).toString());
	}
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
			return list;
		}
        char[] charDigits = digits.toCharArray();
        list = letterCombination(charDigits, list, 0);
        return list;
    }
	private static List<String> letterCombination(char[] charDigits, List<String> list, int point) {
		if (point == charDigits.length) {
			return list;
		}
		int num = Integer.parseInt(String.valueOf(charDigits[point]));
		if (num < 2 || num > 9) {
			return null;
		}
		char[] charStr = KEYS[num].toCharArray();
		List<String> tempList = new ArrayList<String>();

		for (Iterator iterator = list.iterator(); list.size() != 0 && iterator.hasNext();) {
			String string = (String) iterator.next();
			for (char c : charStr) {
				String strTemp = string + c;
				tempList.add(strTemp);
			}
		}
		list.clear();

		if (tempList.size() == 0) {
			for (char c : charStr) {
				tempList.add(String.valueOf(c));
			}
		}
		
		return letterCombination(charDigits, tempList, ++point);
	}
	
	// 别人的方法1ms，我的4ms
	public static List<String> letterCombinations2(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        combination(digits, "", 0, ans);
        return ans;
    }
    private static void combination(String digits, String prefix, int offset ,List<String> ans) { // perfix表示字符串前缀
        int digit = digits.charAt(offset) - '0'; // 字符转化为数字
        String KEY = KEYS[digit];
        if(offset == digits.length() - 1) {
            for(int i = 0; i < KEY.length(); i++) {
                StringBuilder sb = new StringBuilder(prefix);
                sb.append(KEY.charAt(i));
                ans.add(sb.toString());
            }
            return;
        }
        for(int i = 0; i < KEY.length(); i++) {
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(KEY.charAt(i));
            combination(digits, sb.toString(), offset + 1, ans);
        }    
    }
    
    // 模仿别人的方法
	public static List<String> letterCombinations3(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        combinations3(digits, ans, "", 0);
        return ans;
    }
	private static void combinations3(String digits, List<String> ans, String perfix, int point) {
		int num = digits.charAt(point) - '0'; // 不知道字符串的这种.charAt用法
		String Key = KEYS[num];
		if (point == digits.length() - 1) {
			for (int i = 0; i < Key.length(); i++) {
				StringBuilder sBuilder = new StringBuilder(perfix); // 用StringBuilder增加效率
				sBuilder.append(Key.charAt(i));
				ans.add(sBuilder.toString());
			}
			return;
		}
		for (int i = 0; i < Key.length(); i++) {
			StringBuilder sBuilder = new StringBuilder(perfix);
			sBuilder.append(Key.charAt(i));
			combinations3(digits, ans, sBuilder.toString(), point + 1); // 如果是++point则point自增，point+1传递的是+1后的参数
		}
	}
}
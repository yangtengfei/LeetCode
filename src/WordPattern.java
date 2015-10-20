import java.util.Arrays;

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abab";
		String str = "abc qwe abc qwe";
		boolean compare = wordPattern(pattern, str);
		if (compare) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	// 模式匹配
	public static boolean wordPattern(String pattern, String str) {
		// 转换为数组
		String[] strings = str.split(" ");
		char[] strings2 = pattern.toCharArray();

		// 判断长度
		if (strings2.length != strings.length) {
			return false;
		}

		// 数组记录替换
		int[] result1 = replaceString(strings);
		int[] result2 = replaceChar(strings2);
		Arrays.sort(result1);
		Arrays.sort(result2);
		if (!Arrays.equals(result1, result2)) {
			return false;
		}
		return true;
	}

	// 数组替换
	private static int[] replaceChar(char[] strings2) {
		int[] array = new int[strings2.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < strings2.length; i++) {
			for (int j = 0; j < strings2.length; j++) {
				char temp = strings2[i];
				if (strings2[j] == temp) {
					if (array[j] == 0 && temp == strings2[j]) {
							array[j] = i + 1;
					}
				}
			}
		}
		return array;
	}

	// 数组替换
	private static int[] replaceString(String[] strings) {
		int[] array = new int[strings.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < strings.length; i++) {
			String temp = strings[i];
			for (int j = 0; j < strings.length; j++) {
				if (temp.equals(strings[j]) && array[j] == 0) { // 此处注意 == 和
																// equals的区别
					array[j] = i + 1;
				}
			}
		}
		return array;
	}

}

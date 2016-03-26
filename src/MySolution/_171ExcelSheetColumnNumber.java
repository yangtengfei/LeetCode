package MySolution;


public class _171ExcelSheetColumnNumber {
	public static int titleToNumber(String s){
		int num = 1;
		for (int i = s.length(); i > 0; i --) {
			int a = s.length() - i;
			if (a > 0) {
				num += (int)((s.charAt(i-1) - 'A' + 1) * Math.pow(26, a));
			}else {
				num = num + (s.charAt(i-1) - 'A');
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}
}

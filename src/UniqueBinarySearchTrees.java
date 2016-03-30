
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n = (int)(Math.random()*100); // 随机生成数字
		System.out.println(n);
		int num = numTrees(n);
		System.out.println(num);
	}

	private static int numTrees(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		else {
			int[] num = new int[n+1];
			num[0] = num[1] = 1;
			for (int i = 2; i < num.length; i++) {
				num[i] = 0;
				for (int j = 0; j < i; j++) {
					num[i] = num[i] + num[j] *  num[i-j-1]; 
				}
			}
			return num[n];
		}
	}

}

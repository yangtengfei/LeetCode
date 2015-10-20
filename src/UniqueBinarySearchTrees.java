
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
			// 以i为根节点时，其左子树构成为[0,...,i-1],其右子树构成为[i+1,...,n]构成
			// 因此，dp[i] = sigma（dp[0...k] * dp[k+1...i]） 0 <= k < i - 1 
			// dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0] 
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

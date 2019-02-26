
public class _8MaximumMinimumPath {
	public int find(int[][] input) {
		//check
		
		// init
		int m = input.length, n = input[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) continue;
				
				int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
				if (i - 1 >= 0) a = Math.min(input[i][j], input[i - 1][j]);
				if (j - 1 >= 0) b = Math.min(input[i][j], input[i][j - 1]);
				
				input[i][j] = Math.max(a, b);
			}
		}
		
		return input[m-1][n-1];
	}
}

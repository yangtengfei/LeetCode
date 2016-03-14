package MySolution;


public class _112PathSum {
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		treeNode.left = treeNode2;
		boolean flag = hasPathSum(treeNode, 3);
		System.out.println(flag);
	}
	
	public static boolean hasPathSum(TreeNode root, int sum){
		if (root == null) {
			return false;
		}
		sum -= root.val;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				return true;
			}else {
				return false;
			}
			
		}
		return hasPathSum(root.left, sum)||hasPathSum(root.right, sum);
	}
}


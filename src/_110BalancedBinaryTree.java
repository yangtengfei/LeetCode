/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月9日下午5:10:27 
 * @todo:Given a binary tree, determine if it is height-balanced.
 */
public class _110BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root){
		int flag = checkHight(root);
		return flag != -1;
	}

	private static int checkHight(TreeNode node) {
		if (node == null) return 0;
		
		int lh = checkHight(node.left);
		if (-1 == lh) return -1;
		
		int rh = checkHight(node.right);
		if (-1 == rh) return -1;
		
		if (lh - rh < -1 || lh - rh > 1) return -1;
		
		return Math.max(lh, rh)+1;
	}
}

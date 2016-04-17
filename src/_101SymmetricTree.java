/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月17日下午8:31:01 
 * @todo:Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class _101SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricPro(root.left, root.right);
    }

	private boolean isSymmetricPro(TreeNode left, TreeNode right) {
		if (left == null || right == null) return left == right;
		if (left.val != right.val) return false;
		return isSymmetricPro(left.left, right.right) && isSymmetricPro(left.right, right.left);
	}
}

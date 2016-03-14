
/**
 * Given a binary tree, find its maximum depth.
 * @author yangtf
 *
 */
public class _104MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 
	}
}

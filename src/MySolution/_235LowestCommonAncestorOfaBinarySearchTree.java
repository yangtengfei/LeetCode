package MySolution;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * @author yangtf
 *
 */
public class _235LowestCommonAncestorOfaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}else {
			return root;
		}
	}
}

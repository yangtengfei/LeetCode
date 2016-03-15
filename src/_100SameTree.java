
/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author yangtf
 *
 */
public class _100SameTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t1left = new TreeNode(5);
		t1.left = t1left;
		TreeNode t1right = new TreeNode(15);
		t1.right = t1right;
		
		TreeNode t2 = new TreeNode(10);
		TreeNode t2left = new TreeNode(5);
		t2.left = t2left;
		TreeNode t2left_right = new TreeNode(15);
		t2left = t2left_right;
		
		System.out.println(isSameTree(t1, t2));
	}
	public static boolean isSameTree(TreeNode p, TreeNode q){
		if (p == null && q == null) { return true;}
		if (p == null || q == null) { return false;}
		if (p.val == q.val) { return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);}
		return false;
	}
}

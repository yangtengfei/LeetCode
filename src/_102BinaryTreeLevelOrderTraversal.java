import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年7月16日下午7:27:03
 * @todo:Given a binary tree, return the level order traversal of its nodes'
 *             values. (ie, from left to right, level by level).
 */
public class _102BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		
		if (root == null) return lists;
		
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			
			for (int i = 0; i < levelSize; i++) {
				if (queue.peek().left != null)queue.offer(queue.peek().left);
				if (queue.peek().right != null)queue.offer(queue.peek().right);
				list.add(queue.poll().val);
			}
			lists.add(list);
		}
		return lists;
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月20日上午10:12:46
 * @todo:没有完成
 */
public class _107BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node.left = node2;
		System.out.println(levelOrderBottom(node));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null) return lists;
		Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
		int high = 0;
		maps = getLevel(root, maps, high);

		for (Integer key : maps.keySet()) {
			List<Integer> list = maps.get(key);
			lists.add(list);
		}

		return lists;
	}

	private static Map<Integer, List<Integer>> getLevel(TreeNode node,
			Map<Integer, List<Integer>> map, int high) {
		List<Integer> list = new ArrayList<Integer>();

		// 放入本层的值
		list = map.get(high);
		if (list == null) list = new ArrayList<Integer>();
		list.add(node.val);
		map.put(high, list);

		// 继续层次遍历
		if (node.left != null)
			return getLevel(node.left, map, high++);
		if (node.right != null)
			return getLevel(node.right, map, high++);
		return map;
	}
}

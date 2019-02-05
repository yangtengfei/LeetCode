// Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
// 参考链接：https://yeqiuquan.blogspot.com/2017/03/lintcode-597-subtree-with-maximum.html
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class _597SubtreeWithMaximumAverage {
	// 定义数据结构，方便处理数据
	class ResultType{
		TreeNode node;
		int sum, size;
		public ResultType(TreeNode node, int sum, int size){
			this.node = node;
			this.sum = sum;
			this.size = size;
		}
	}
	
	// 定义初始数据，方便比较
	private static ResultType result = null;
	
	// 寻找目标子树
	public TreeNode findSubtree(TreeNode root){
		if(root == null) return null;
		
		ResultType resultType = finder(root);
		
		return resultType.node;
	}
	
	// 递归实现，比较的地方把分母移到对面
	private ResultType finder(TreeNode node){
		// 判空
		if(node == null) return new ResultType(node , 0, 0);
		
		// 递归
		ResultType leftType = finder(node.left);
		ResultType rightType = finder(node.right);
		
		// 计算当前值
		ResultType curResult = new ResultType(node, leftType.sum + rightType.sum + node.val, leftType.size + rightType.size + 1);
		if(result == null || result.sum * curResult.size < result.size * curResult.sum) result = curResult;
		
		// 返回
		return result;
	}
}

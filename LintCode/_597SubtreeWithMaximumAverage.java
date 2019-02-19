import java.util.Map;

// Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// 需要携带的数据有节点、平均值，平均值不好存储，所以存储sum和size，且需要额外数据结构
// 需要找所有子树，因此需要递归
// 递归时，先找到叶子节点的值，然后向上计算
// 设置全局变量，用于保存最大节点
// 注意递归中返回的值应为当前子树计算的结果值。
public class _597SubtreeWithMaximumAverage {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
	 // 数据结构
	class ResultType{
		TreeNode node;
		int sum,size;
		public ResultType(TreeNode node, int sum, int size){
			this.node = node;
			this.sum = sum;
			this.size = size;
		}
	} 
	
	private ResultType result = null; // 去掉static
	
    public TreeNode findSubtree2(TreeNode root) {
       if(root == null){
		   return root;
	   }

	   finder(root);
	   
	   return result.node;
    }
	
	private ResultType finder(TreeNode root){
		if(root == null){
			return new ResultType(root, 0, 0);
		}
		
		ResultType leftType = finder(root.left);
		ResultType rightType = finder(root.right);
		
		ResultType curResult = new ResultType(root, 
			leftType.sum + rightType.sum + root.val, 
			leftType.size + rightType.size + 1);
			
		if(result == null || curResult.sum * result.size > result.sum * curResult.size){
			result = curResult;
		}
		
		return curResult; // 注意这里，返回的应该是当前的结果，用于递归。最大的结果由全局变量result存储
	}
}

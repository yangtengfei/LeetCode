package MySolution;

/**
 * leetcode的测试例子不足，
 * node.val = node.next.val;
 * node.next = node.next.next;
 * 也能通过，不知道next.next是否存在
 * @author yangtf
 *
 */
public class _237DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		if (node.next.next == null) {
			node.next = null;
		} else {
			node.next = node.next.next;
		}
	}
}

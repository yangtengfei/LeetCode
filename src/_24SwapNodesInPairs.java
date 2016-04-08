/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月7日上午9:40:34 
 * @todo:Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class _24SwapNodesInPairs {
	public ListNode swapPairs(ListNode head){
		ListNode top = new ListNode(0);
		top.next = head;
		ListNode node = top;
		while (node.next != null && node.next.next != null) {
			ListNode first = node.next;
			ListNode second = node.next.next;
			first.next = second.next;
			node.next = second;
			second.next = first;
			node = node.next.next;
		}
		return top.next;
	}
}

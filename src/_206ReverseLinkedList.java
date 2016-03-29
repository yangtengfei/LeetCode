
/**
 * Reverse a singly linked list.
 * @author yangtf
 *
 */
public class _206ReverseLinkedList {
	public ListNode reverseList(ListNode head){
		ListNode node = null;
		while (head != null) {
			ListNode node2 = head.next;
			head.next = node;
			node = head;
			head = node2;
		}
		return node;
	}
}

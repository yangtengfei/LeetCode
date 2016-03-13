
/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. 
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * 将奇数的和偶数的分别串联，最后奇数的末尾串联上偶数的开头
 * @author yangtf
 *
 */
public class _328OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (odd.next != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
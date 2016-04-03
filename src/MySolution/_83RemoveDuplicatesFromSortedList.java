package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月2日上午10:36:55 
 * @todo:Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 1ms
 */
public class _83RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (null != head) {
			ListNode node = head;
	        while (null != node.next) {
	        	if (node.val != node.next.val)node = node.next;
	        	else if (node.next.next == null)node.next = null;
				else node.next = node.next.next;
			}
		}
        return head;
    }
}

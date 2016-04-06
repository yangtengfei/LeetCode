
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月6日上午10:55:22 
 * @todo:Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class _21MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode nodeHead;
        if (l1.val <= l2.val) {
			nodeHead = l1;
			nodeHead.next = mergeTwoLists(l1.next, l2);
		}else {
			nodeHead = l2;
			nodeHead.next = mergeTwoLists(l1, l2.next);
		}
        return nodeHead;
    }
}

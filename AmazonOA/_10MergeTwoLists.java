public class _10MergeTwoLists {
	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(-1);
		ListNode cur = temp;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = (l1 == null) ? l2 : l1;
		return temp.next;
	}
}


package MySolution;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年5月6日上午9:11:10 
 * @todo:Given a linked list, determine if it has a cycle in it.
 */
public class _141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
        	walker = walker.next;
        	runner = runner.next.next;
        	if (walker == runner) return true;
        }
        return false;
    }
}

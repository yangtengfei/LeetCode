package MySolution;

import java.util.HashMap;
import java.util.Map;

public class _146LRUCache {
/*	借助原有类LinkedHashMap实现
	private static class RewriteLinkedHashMap<K,V> extends LinkedHashMap<K, V>{
		private static final long serialVersionUID = 1L;
		int capacity;
		
		public RewriteLinkedHashMap(int capacity) {
			super(16, 0.75f, true);
			this.capacity = capacity;
		}
		
		protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
			return size() > capacity;
		}
	}
	
	private Map<Integer, Integer> map;
	
	public _146LRUCache(int capacity) {
		map = new RewriteLinkedHashMap<>(capacity);
	}
	
	public int get(int key) {
		return map.containsKey(key) ? map.get(key) : -1;
	}
	
	public void put(int key, int value) {
		map.put(key, value);
	}*/

	public static void main(String[] args) {
		_146LRUCache cache = new _146LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		int val = cache.get(1); System.out.println(val);
		cache.put(3, 3);
		int val2 = cache.get(2); System.out.println(val2);
		cache.put(4, 4);
		int val3 = cache.get(1); System.out.println(val3);
		int val4 = cache.get(3); System.out.println(val4);
		int val5 = cache.get(4); System.out.println(val5);
	}
	
	// 手动实现
	class DoubleListNode{
		public int key, val;
		public DoubleListNode pre, next;
		
		public DoubleListNode(int key, int value) {
			this.val = value;
			this.key = key;
		}
	}
	
	HashMap<Integer, DoubleListNode> map = new HashMap<Integer, DoubleListNode>();
	DoubleListNode head = new DoubleListNode(0, 0);
	DoubleListNode end = head;
	private int capacity;
	
	public _146LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleListNode node = map.get(key);
			setHead(node);
			return node.val;
		}else {
			return -1;
		}
	}
	
	private void setHead(DoubleListNode node) {
		DoubleListNode pre = node.pre;
		DoubleListNode next = node.next;
		if (pre == null && next != null) return; // head node
		
		node.next = head;
		head.pre = node;
		node.pre = null;
		
		if (pre != null && next == null) { // end node
			pre.next = null;
			end = pre;
		}else if (pre != null && next != null) {
			pre.next = next;
			next.pre = pre;	
		}
		
		head = node;
		
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DoubleListNode node = map.get(key);
			node.val = value;
			setHead(node);
		}else {
			DoubleListNode node = new DoubleListNode(key, value);
			setHead(node);
			map.put(key, node);
			if (map.size() > capacity) {
				map.remove(end.pre.key);
				end = end.pre;
			}
		}
	}
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

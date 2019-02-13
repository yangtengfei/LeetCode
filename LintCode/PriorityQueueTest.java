

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		// origin
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		/**
		 * 上式等同于
		 * PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(3, new Comparator<Integer>() {
		 *     public int compare(Integer a, Integer b) {
		 * 	       return a - b;
		 *     }
		 * });
		 */
		pQueue.add(1);
		pQueue.add(20);
		pQueue.add(-10);
		System.out.println(pQueue.toString()); // 插入顺序的反序
		while (!pQueue.isEmpty()) { // 小根堆
			System.out.println(pQueue.poll());
		}
		
		// changed
		PriorityQueue<Integer> pQ = new PriorityQueue<>(3, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		pQ.add(1);
		pQ.add(20);
		pQ.add(-10);
		System.out.println(pQ.toString()); // 插入顺序的正序
		while (!pQ.isEmpty()) {
			System.out.println(pQ.poll()); // 大根堆
		}
	}
}

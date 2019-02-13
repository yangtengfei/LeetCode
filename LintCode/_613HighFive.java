import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are two properties in the node student id and scores, 
 * to ensure that each student will have at least 5 points, 
 * find the average of 5 highest scores for each person.
 * 
 * Example
 * Given results = 
 * [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
 * @author yangtf3
 *
 */
public class _613HighFive {
	public Map<Integer, Double> highFive(Record[] results) {
		// init
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		Map<Integer, PriorityQueue<Integer>> priorityMap = new HashMap<Integer, PriorityQueue<Integer>>();
		int k = 5;
		
		// high five
		for (Record record : results) {
			if (!priorityMap.containsKey(record.id)) {
				PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return a - b;
					}
				});
				priorityMap.put(record.id, queue);
			}
			PriorityQueue<Integer> pQueue = priorityMap.get(record.id);
			pQueue.add(record.score);
			if (pQueue.size() > k) {
				pQueue.poll();
			}
		}
		
		// ave
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : priorityMap.entrySet()) {
			int id = entry.getKey();
			PriorityQueue<Integer> pQ = entry.getValue();
			int num = pQ.size();
			int score = 0;
			while (!pQ.isEmpty()) {
				score += pQ.poll();
			}
			double aveScore = score / num;
			map.put(id, aveScore);
		}
		
		return map;
	}
}

class Record {
	public int id, score;
    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }
}

// 根据野球拳刷刷刷的答案code，没有办法验证。博客网址：https://yeqiuquan.blogspot.com/2017/03/lintcode-613-high-five.html

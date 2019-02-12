import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Given a list of words and an integer k, return the top k frequent words in the list.


// You should order the words by the frequency of them in the return list, the most frequent one comes first. 
// If two words has the same frequency, the one with lower alphabetical order come first.

// Do it in O(nlogk) time and O(n) extra space.


public class _471TopKFrequentWords {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
	public static void main(String[] args) {
		String[] arr = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
		int k = 5;
		System.out.println(Arrays.toString(topKFrequentWords(arr, k)));
	}
	
    public static String[] topKFrequentWords(String[] words, int k) {
    	String[] arr = new String[k];
    	if (words == null || words.length == 0 || k <= 0) {
			return arr;
		}
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
    		public int compare(String a, String b) {
    			int sub = map.get(a) - map.get(b);
    			if (sub == 0) {
					sub = b.compareTo(a);
				}
    			return sub;
    		}
		});
    	System.out.println(System.currentTimeMillis());
    	for (int i = 0; i < words.length; i++) {
			Integer num = map.get(words[i]);
			if (num == null) {
				num = 0;
			}
			map.put(words[i], ++num);
			if(queue.contains(words[i])) queue.remove(words[i]);
			queue.offer(words[i]);
			if (queue.size() > k) {
				queue.poll();
			}
		}
    	
    	for(int i = k - 1; i >= 0; i--) {
    		arr[i] = queue.poll();
    	}
    	System.out.println(System.currentTimeMillis());
        return arr;
    }
}

// 更快的解法
/**
class Pair {
String word;
int freq;
public Pair(String word, int freq) {
    this.word = word;
    this.freq = freq;
}
}

public class Solution {
public String[] topKFrequentWords(String[] words, int k) {
// write your code here
// 1. hashmap存word, frequency (建立一个class Pair用于 word, frequency)
// 2. 遍历hashmap，将pair用priorityqueue来存放pair （按频率最小-大）
// 在存放的过程中，因为我们只需要TOP K个，那么所有当PriorityQueue size>K时
// 就将queue的顶端元素弹出来，最后就只剩下K个元素在queue中
//3。将queue剩下的K元素倒出来，倒序放置结果中
String[] result = new String[k];

if (words == null || words.length == 0 || k == 0) {
    return result;
}

//. hashmap
HashMap<String, Integer> mapping = new HashMap<>();
for (String str : words) {
    if (!mapping.containsKey(str)) {
        mapping.put(str, 1);
    } else {
        mapping.put(str, mapping.get(str) + 1);
    }
}

// 遍历hashmap，放入priorityQueue
Queue<Pair> queue = new PriorityQueue<Pair>(k, new PairComparator());

for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
    Pair pair = new Pair(entry.getKey(), entry.getValue());
    queue.offer(pair);
    
    if (queue.size() > k) {
        queue.poll();
    }
}

// 把最后剩下的4个倒给result
while (!queue.isEmpty()) {
    Pair curPair = queue.poll();
    result[--k] = curPair.word;
}

return result;
}

}

//先比较频率， 如果频率相同的情况下，比较word字母顺序
class PairComparator implements Comparator<Pair> {
public int compare(Pair p1, Pair p2) {
if (p1.freq != p2.freq) {
    return p1.freq - p2.freq;
} 
return p2.word.compareTo(p1.word);
}
}
*/
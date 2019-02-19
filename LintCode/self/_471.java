package self;

// Given a list of words and an integer k, return the top k frequent words in the list.

// You should order the words by the frequency of them in the return list, 
// the most frequent one comes first. 
// If two words has the same frequency, the one with lower alphabetical order come first.

// Do it in O(nlogk) time and O(n) extra space.

public class _471 {
	public String[] topKFrequentWords(String[] words, int k) {
		// check
		if (k < 0) {
			return new String[0];
		}
		String[] topK = new String[k];
		if (words == null || words.length == 0 || k == 0) {
			return topK;
		}
		
		// init

		
		// loop
		
		return topK;
	}
}

class Word{
	String word;
	int num;
	public Word(String word, int num) {
		this.word = word;
		this.num = num;
	}
}

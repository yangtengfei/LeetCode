import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _16MostCommonWord {
	public String mostCommonWord(String paragragh, String[] banned) {
		paragragh += ".";
		
		Set<String> banSet = new HashSet<String>();
		for (String word: banned) banSet.add(word);
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		String anString = "";
		int freq = 0;
		StringBuilder word = new StringBuilder();
		
		for(char c : paragragh.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			}else if (word.length() > 0) {
				String wordStr = word.toString();
				if (!banSet.contains(wordStr)) {
					count.put(wordStr, count.getOrDefault(wordStr, 0) + 1);
					if (count.get(wordStr) > freq) {
						anString = wordStr;
						freq = count.get(wordStr);
					}
				}
				word = new StringBuilder();
			}
		}
		
		return anString;
	}
}

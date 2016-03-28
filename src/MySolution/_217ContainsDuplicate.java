package MySolution;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * @author yangtf
 *
 */
public class _217ContainsDuplicate {
	// My solution ==> 用set会更好
	public boolean containsDuplicase(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (null != map.get(nums[i])) {
				return true;
			}
			map.put(nums[i], 1);
		}
		return false;
	}

	// best 不理解
	public boolean containsDuplicate(int[] nums) {
		byte[] mark = new byte[150000];
		for (int i : nums) {
			int j = i / 8;
			int k = i % 8;
			int check = 1 << k;
			if ((mark[j] & check) != 0) {
				return true;
			}
			mark[j] |= check;
		}
		return false;
	}
}

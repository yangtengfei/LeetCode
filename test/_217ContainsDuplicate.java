import java.util.HashMap;
import java.util.Map;

public class _217ContainsDuplicate {
	// My solution
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

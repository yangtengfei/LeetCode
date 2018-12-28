package MySolution;
import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * @author yangtf3
 * 对撞指针
 * 125 对于字符串的问题：空字符串怎么办、字符的定义、大小写问题需要考虑。
 * 344 345
 * 11
 */
public class _167TwoSumII {
	public static void main(String[] args) {
		int[] arr = {2,3,4};
		int target = 6;
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}
	
	// 暴力解法；因为有序所以使用二分搜索；最好的方法 对撞指针
	
	// 考虑没有解怎么样，有多个解怎么样
    public static int[] twoSum(int[] numbers, int target) {
    	// 因为下面有抛出异常，所以这里可以写可以不写
    	if (numbers == null || numbers.length == 0) {
			return numbers;
		}
    	int num1 = 0, num2 = numbers.length - 1;
    	while (num1 < num2) { // 若是 <= 那么表示可以使用重复的元素
			if (numbers[num1] + numbers[num2] == target) {
				int[] arr = {num1 + 1, num2 + 1};
				return arr;
			}else if (numbers[num1] + numbers[num2] > target) {
				num2--;
			}else {
				num1++;
			}
		}
    	throw new IllegalArgumentException();
    }
}

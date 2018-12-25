package MySolution;
import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author yangtf3
 *
 */
public class _75SortColors {
	public static void main(String[] args) {
		int[] arr = {2,0,2,1,1,0};
		sortColors2(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	// 暴力排序
	// 计数排序
	
    public static void sortColors(int[] nums) {
    	int[] arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
        System.out.println(Arrays.toString(arr));
    }
    
    // 三路快排 注意执行完一个if，会继续执行下一个
    public static void sortColors2(int[] nums) {
    	int zero = -1; // [0,zero] == 0
    	int two = nums.length; // [two,nums.length] == 2
    	for (int i = 0; i < two;) {
			if (nums[i] == 0) {
				zero++;
				int temp = nums[zero];
				nums[zero] = nums[i];
				nums[i] = temp;
				i++;
			}
			else if (nums[i] == 1) {
				i++;
			}
			else {
				two--;
				int temp = nums[two];
				nums[two] = nums[i];
				nums[i] = temp;	
			}
		}
    }
}

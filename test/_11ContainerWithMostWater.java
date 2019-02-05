
/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author yangtf3
 *
 */
public class _11ContainerWithMostWater {
	
	// 考虑清楚一点，
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	
    public static int maxArea(int[] height) {
    	int left = 0, right = height.length - 1, maxArea = 0, hight = 0; // [left, right]
    	while (left < right) {
    		if (height[left] < height[right]) {
				hight = height[left];
				maxArea = (right - left) * hight > maxArea ? (right - left) * hight : maxArea;
				left ++;
			}else {
				hight = height[right];
				maxArea = (right - left) * hight > maxArea ? (right - left) * hight : maxArea;
				right --;
			}
    		// 之前把maxArea...写在这里了，导致比较完大小后l/r++,计算结果出现误差
		}
        return maxArea;
    }
    
    // 官方题解
    public static int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}

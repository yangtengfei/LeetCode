package MySolution;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月23日下午2:05:09
 * @todo:TODO
 */
public class _00_01 {
	public static void main(String[] args) {
		float[] a = {0, 0, 0, 0};
		int[] b = new int[a.length];
		b = Puzzle(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
	
	public static int[] Puzzle(float[] a) {
		int[] b = new int[a.length];
		float flag = -3.40E+38f;
		int[] list = new int[0];
		for (int j = 0; j < a.length;) {
			float min = 3.4028235E38f;
			for (int i = 0; i < a.length; i++) {
				if (flag < a[i] && a[i] < min) {
					min = a[i];
					list = clear(list);
					list = add(list, i);
					continue;
				}
				if (a[i] == min) {
					list = add(list, i);
				}
			}
			flag = min;
			for (Integer integer : list) {
				b[integer] = j;
			}
			j = j + list.length;
		}
		return b;
	}

	private static int[] add(int[] list, int i) {
		int[] list2 = new int[list.length + 1];
		for (int j = 0; j < list.length; j++) {
			list2[j] = list[j];
		}
		list2[list.length] = i;
		return list2;
	}

	private static int[] clear(int[] list) {
		return new int[0];
	}
}

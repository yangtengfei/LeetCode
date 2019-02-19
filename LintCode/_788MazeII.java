import java.util.Arrays;
import java.util.PriorityQueue;

public class _788MazeII {
	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] dest = { 4, 4 };
		System.out.println(shortestDistance(maze, start, dest));
	}

	private static int shortestDistance(int[][] maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length]; // 构造距离二维数组
		for (int[] row : distance) // 给数组中的元素赋值
			Arrays.fill(row, Integer.MAX_VALUE);
		distance[start[0]][start[1]] = 0; // 初始化开始点的距离
		dijkstra(maze, start, distance); // 核心算法
		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]]; // 返回距离
	}

	private static void dijkstra(int[][] maze, int[] start, int[][] distance) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 优先队列，a[2],b[2] 为距离，构造小根堆
		queue.offer(new int[] { start[0], start[1], 0 });
		while (!queue.isEmpty()) {
			int[] s = queue.poll(); // 用小根堆找到最小距离的点
			if (distance[s[0]][s[1]] < s[2]) // 已经计算过点的有可能重新计算
				continue;
			for (int[] dir : dirs) {
				int x = s[0] + dir[0]; // 前、后、左、右 走一步
				int y = s[1] + dir[1]; // 前、后、左、右 走一步
				int count = 0;
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					// 在迷宫范围内，且是可走空间(不是墙)，while循环，是不会停止走动，直到撞到墙退出循环
					x += dir[0];
					y += dir[1];
					count++;
				}
				if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
					// 比较x,y到s[0],s[1]的距离，s[0],s[1]是小根堆中最小距离的点，也就是已经计算的节点中，最近的点。
					distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count; // 选中点的距离更新
					queue.offer(new int[] { x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]] });
				}
			}
		}
	}
}

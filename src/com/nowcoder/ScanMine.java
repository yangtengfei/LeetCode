package com.nowcoder;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.
 * 只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,
 * 一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 
 * 问:兰博最多可以清理多少个蘑菇?
 * 此代码没有测样例
 * @author yangtf
 *
 */
public class ScanMine {
	static int N,M,K;
	static int x,y;
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(reader);
		String[] fl = br.readLine().split(",");
		N = Integer.parseInt(fl[0]);
		M = Integer.parseInt(fl[1]);
		K = Integer.parseInt(fl[2]);
		
		int[][] floor = new int[N][M];
		while (br.readLine() != null) {
			String[] point = br.readLine().split(",");
			int x = Integer.parseInt(point[0]);
			int y = Integer.parseInt(point[1]);
			floor[x][y]++;
		}
		br.close();
		int max = 0;
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				int mineNum = floor[i][j] + floor[i-1][j-1] + floor[i][j-1] + floor[i+1][j-1] + floor[i-1][j] + floor[i+1][j]
						+ floor[i-1][j+1] + floor[i][j+1] + floor[i+1][j+1];
				if (max < mineNum) {
					max = mineNum;
				}
			}
		}
		System.out.println(max);
	}
}

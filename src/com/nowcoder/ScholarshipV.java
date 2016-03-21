package com.nowcoder;

import java.util.Scanner;

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,
 * 若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。
 * 为了拿到奖学金，小v至少要花多少时间复习。
 * @author yangtf
 *
 */
public class ScholarshipV {
	static int n,r,avg;
	static int time = 0;
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		n = in.nextInt();// n门课
		r = in.nextInt();// 满分
		avg = in.nextInt();// 平均成绩
		
		int[] a = new int[n]; // 平时成绩
		int[] b = new int[n]; // 提升一分需要的时间
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		in.close();
	/*	FileReader reader = new FileReader("E://testdata2.txt");
		BufferedReader br = new BufferedReader(reader);
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		r = Integer.parseInt(str[1]);
		avg = Integer.parseInt(str[2]);
		
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			String[] str2 = br.readLine().split(" ");
			a[i] = Integer.parseInt(str2[0]);
			b[i] = Integer.parseInt(str2[1]);
		}
		br.close();*/
		
		// 当平时成绩小于平均成绩是才继续复习
		int sa = 0; // 总平时成绩
		int ns; // 还需要的成绩
		for (int i = 0; i < a.length; i++) {
			sa += a[i];
		}
		
		ns = avg * n - sa;
		while (ns > 0) {
			int p = 0,e = Integer.MAX_VALUE; // 平时成绩和提升耗时
			for (int i = 0; i < b.length; i++) {
				if (e > b[i]) {
					e = b[i];
					p = i;
				}
			}
			b[p] = Integer.MAX_VALUE;
			
			int score = 0;
			if (ns >= (r - a[p])) {
				score = r - a[p];
				time += e * score;
				ns -= score;
			}else {
				time += e * ns;
				ns = 0;
			}
		}
		System.out.println(time);
	}
}
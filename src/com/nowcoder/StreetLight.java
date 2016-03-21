package com.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，
 * 为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小
 * 请找到这个最小的d。
 * @author yangtf
 *
 */
public class StreetLight {
	static long l;	// 路长
	static int n;	// 路灯数
	static int[] a; // 路灯组成的数组
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		l = scanner.nextInt();
		n = scanner.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();
		
		// 排序
	/*	for(int i = n-1; i > 0; i--){
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t; 
				}
			}
		}*/
		Arrays.sort(a);
		
		long maxD = a[0];
		for (int i = 1; i < n; i++) {
			if (maxD < a[i] - a[i-1]) {
				maxD = a[i] - a[i-1];
			}
		}
		if (maxD < l - a[n-1]) {
			maxD = l - a[n-1];
		}
		System.out.println(maxD/2);
	}
}

package com.nowcoder;

import java.util.Scanner;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月18日下午2:51:49 
 * @todo:求最长公共子序列，可用动态规划算法优化
 */
public class LongestCommonSubstring {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("请输入第一行");
		String str1 = sca.nextLine();
		System.out.println("请输入第二个字符串");
		String str2 = sca.nextLine();
		sca.close();
		int len = longestCommonSubstring(str1,str2);
		System.out.println(len);
	}

	private static int longestCommonSubstring(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		String max = len1 > len2 ? str1 : str2;
		String min = len1 > len2 ? str2 : str1;
		for (int i = min.length(); i > 1; i--) {
			for (int j = 0; j < i; j++) {
				String sub = min.substring(j, i);
				if (max.contains(sub)) return (i - j);
			}
		}
		return 0;
	}
}

package com.nowcoder;

public class BubbleSort {
	public static void main(String[] args) {
		int[] A = {1,2,3,5,2,3};
		int n = 6;
		bubbleSort(A, n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	private static void bubbleSort(int[] a, int n) {
		for (int i = a.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
}

package com.nowcoder;

public class SelectionSort {

	public static void main(String[] args) {
		/**
		 * [54,35,48,36,27,12,44,44,8,14,26,17,28],13
		 */
		int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		int n = 13;
		A = selectionSort(A, n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	private static int[] selectionSort(int[] A, int n) {
		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if (A[i] > A[j]) {
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
 		}
		return A;
	}

}

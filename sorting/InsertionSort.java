package com.eg.sorting;

public class InsertionSort {

	public static void InsertionSorting(int[] arr) {
		int j;
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			j = i - 1;
			while (j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 15, 5, 20, 35, 2, 42, 67, 17 };
		long startTime = System.currentTimeMillis();
		InsertionSorting(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

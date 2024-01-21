package com.eg.sorting;

public class SelectionSort {
	public static void SelectionSorting(int[] arr) {
		int min;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

		}
	}

	public static void main(String[] args) {
		int arr[] = { 15, 5, 20, 35, 2, 42, 67, 17 };
		long startTime = System.currentTimeMillis();
		SelectionSorting(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
package com.eg.sorting;

public class BubbleSort {

	public static void BubbleSorting(int arr[]) {
		boolean isSwap;
		for (int i = 0; i < arr.length - 1; i++) {
			isSwap = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwap = true;
				}
			}
			if (!isSwap) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 15, 5, 20, 35, 2, 42, 67, 17 };
		long startTime = System.currentTimeMillis();
		BubbleSorting(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

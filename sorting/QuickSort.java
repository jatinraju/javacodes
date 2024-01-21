package com.eg.sorting;

public class QuickSort {

	public static int Partition(int[] arr, int lb, int ub) {
		int start = lb;
		int pivot = arr[lb];
		int end = ub;
		while (start < end) {
			while (start <= ub && arr[start] <= pivot) {
				start++;
			}

			while (end >= lb && arr[end] > pivot) {
				end--;
			}

			if (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}

		}

		int temp2 = arr[end];
		arr[end] = arr[lb];
		arr[lb] = temp2;
		return end;

	}

	public static void QuickSorting(int[] arr, int lb, int ub) {
		if (lb < ub) {
			int loc = Partition(arr, lb, ub);
			QuickSorting(arr, lb, loc - 1);
			QuickSorting(arr, loc + 1, ub);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 537, 21, 965, 302, 785, 49, 812, 403, 104, 625, 719, 148, 937, 616, 857, 382, 674, 293, 546, 95,
				198, 823, 761, 428, 179, 534, 297, 660, 52, 881, 315, 731, 68, 249, 943, 106, 458, 874, 207, 597, 439,
				783, 164, 652, 38, 892, 741, 376, 619, 280, 513, 857, 143, 896, 604, 215, 780, 392, 29, 694, 108, 817,
				473, 236, 980, 109, 864, 632, 515, 80, 259, 709, 587, 130, 824, 451, 950, 267, 611, 37, 189, 902, 726,
				343, 694, 832, 275, 536, 907, 154, 770, 429, 681, 586, 325, 978, 718, 83, 46, 926 };
		long startTime = System.currentTimeMillis();
		QuickSorting(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
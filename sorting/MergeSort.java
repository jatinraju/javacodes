package com.eg.sorting;

public class MergeSort {

	public static void MergeSorting(int[] arr, int lb, int mid, int ub) {
		int i = lb;
		int j = mid + 1;
		int k = lb;

		int[] brr = new int[arr.length];

		while (i <= mid && j <= ub) {
			if (arr[i] <= arr[j]) {
				brr[k] = arr[i];
				i++;
				k++;
			} else {
				brr[k] = arr[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			brr[k] = arr[i];
			k++;
			i++;
		}

		while (j <= ub) {
			brr[k] = arr[j];
			k++;
			j++;
		}

		// copy brr to arr
		for (int index = lb; index <= ub; index++) {
			arr[index] = brr[index];
		}
	}

	public static void DivideArray(int[] arr, int lb, int ub) {

		if (lb < ub) {
			int mid = (lb + ub) / 2;
			DivideArray(arr, lb, mid);
			DivideArray(arr, mid + 1, ub);
			MergeSorting(arr, lb, mid, ub);
		}

	}

	public static void main(String[] args) {
//		int[] arr = { 537, 37, 965, 302, 785, 49, 812, 403, 104, 625, 719, 148, 937, 616, 857, 382, 674, 293, 546, 95,
//				198, 823, 761, 428, 179, 534, 297, 660, 52, 881, 315, 731, 68, 249, 943, 106, 458, 874, 207, 597, 439,
//				783, 164, 652, 38, 892, 741, 376, 619, 280, 513, 857, 143, 896, 604, 215, 780, 392, 29, 694, 108, 817,
//				473, 236, 980, 109, 864, 632, 515, 80, 259, 709, 587, 130, 824, 451, 950, 267, 611, 21, 189, 902, 726,
//				343, 694, 832, 275, 536, 907, 154, 770, 429, 681, 586, 325, 978, 718, 83, 46, 926 };
		int[] arr = { 15, 5, 20, 35, 2, 42, 67, 17 };
		long startTime = System.currentTimeMillis();
		DivideArray(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

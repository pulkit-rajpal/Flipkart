package com.flipkart.utils;

public class Sort {

	public static boolean isSorted(int[] arr) {
		boolean isAscending = false;

		if (arr.length < 2) { // if the array has less than 2 elements, must be sorted
			return true;
		}

		if (arr[0] < arr[1]) { // do we think this array is sorted ascending?
			isAscending = true;
		} else {
			int index = 0;
			while (arr[index] == arr[index + 1] && index++ < arr.length - 2) {
				// keep checking for sorting if array consists of equal values
				if (index >= arr.length - 2) {
					return true; // whole array consists of equal values
				}
			}
			// now that equal values were skipped, check for sorting again
			isAscending = arr[index] < arr[index + 1];
		}

		// check all elements of the array
		for (int i = 0; i < arr.length - 1; i++) {
			if (isAscending) {
				if (arr[i] > arr[i + 1]) {
					return false;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
}

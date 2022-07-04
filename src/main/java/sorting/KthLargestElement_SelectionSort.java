package sorting;

import java.util.Arrays;

/**
 * O(N*k)
 * Selection sort if it's done N-1 times O(N*N-1) = O(n^2)
 */
public class KthLargestElement_SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 1, 15, 7, 6, 2};
        int k = 1;

        kLargestElement(arr, k);
        System.out.println("index " + Arrays.toString(arr) + "  " + arr[arr.length - k]);
    }

    private static void kLargestElement(int[] arr, int k) {

        for (int i = 0; i < k; i++) {
            int start = 0;
            int end = arr.length - 1 - i;
            finLargestAndSwap(arr, start, end);

        }

    }

    private static void finLargestAndSwap(int[] arr, int start, int end) {
        int largest = start;

        for (int i = start; i <= end; i++) {
            if (arr[largest] < arr[i])
                largest = i;
        }

        int temp = arr[end];
        arr[end] = arr[largest];
        arr[largest] = temp;

    }
}

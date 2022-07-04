package sorting;

import java.util.Arrays;

/**
 * More swap than selectionSort
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 1, 15, 7, 6, 2};
        int k = 6;
        getKLargestElement(arr, k);
        System.out.println("arr " + Arrays.toString(arr) + " element " + arr[arr.length - k]);
    }

    private static void getKLargestElement(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            bubbleSort(arr, 0, arr.length - 1 - i);
        }
    }

    private static void bubbleSort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

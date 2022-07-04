package sorting;

import java.util.Arrays;

/**
 * Divide and conquer
 * O(nlogn)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 3, 6, 4, 1, 5, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("arr " + Arrays.toString(arr));
    }


    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int z = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[z++] = arr[i++];
            } else {
                temp[z++] = arr[j++];

            }
        }

        while (i <= m) {
            temp[z++] = arr[i++];
        }
        while (j <= r) {
            temp[z++] = arr[j++];
        }


        z = 0;
        for (int k = l; k <= r; k++) {
            arr[k] = temp[z++];
        }
    }
}

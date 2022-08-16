package playground;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 0, 2, 3, 7, 8};
        arr = insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // 5, 1, 0, 2, 3, 7, 8
    // 1, 5, 0, 2, 3, 7, 8
        //1, 0, 5, 2, 3, 7, 8
        //0, 1, 5, 2, 3, 7, 8
    //0, 1, 5, 2, 3, 7, 8
         //0, 1, 2, 5, 3, 7, 8
    //0, 1, 2, 5, 3, 7, 8
        //0, 1, 2, 3, 5, 7, 8
    //0, 1, 2, 3, 5, 7, 8
    private static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j = j - 1;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

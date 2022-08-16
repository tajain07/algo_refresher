package sorting;

import java.util.Arrays;

public class QuickSort_Random_Pivot {
    public static void main(String[] args) {
        int[] arr = new int[]{40, 41, 17, -22, 25, 55, -18, 35, 10, 25, 33, 19, 44, 51, 25};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        //Value will range between 0 - 1
        final double random = Math.random();

        int pivot = (int) (l + (random * (h - l + 1)));
        swap(arr, pivot, h);
        pivot = h;
        //System.out.println("random value " + random + " (h - l + 1) " + (h - l + 1) + " l " + l + " random pivot " + pivot);
        int partitionLoc = partition(arr, l, h, pivot);
        if (partitionLoc - l < h - partitionLoc) {
            quickSort(arr, l, partitionLoc - 1);
            quickSort(arr, partitionLoc + 1, h);
        } else {
            quickSort(arr, partitionLoc + 1, h);
            quickSort(arr, l, partitionLoc - 1);
        }

    }

    private static int partition(int[] arr, int l, int h, int pivot) {
        int i = l;
        int j = l;
        for (; j < h; j++) {

            if (arr[pivot] >= arr[j]) {
                int jElement = arr[j];
                int k = j;
                while (k > i) {
                    swap(arr, k, k - 1);
                    k--;
                }

                arr[i] = jElement;
                i = i + 1;
            }
        }

        while (j > i) {
            swap(arr, j, j - 1);
            j--;
        }

        return j;

    }

    private static void swap(int[] arr, int k, int i) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}

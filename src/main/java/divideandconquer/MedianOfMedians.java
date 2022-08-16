package divideandconquer;

import java.util.Arrays;

public class MedianOfMedians {
    public static void main(String[] args) {
        int[] arr = {25, 24, 33, 39, 3, 18, 19, 31, 23, 49, 45, 16, 1, 29, 40, 22, 15, 20, 20, 4, 13, 34};
        int median = findMedian(arr);
        System.out.println("median " + median);

    }

    private static int findMedian(int[] arr) {
        int median = findMedianUtil(arr, arr.length / 2 + 1, 0, arr.length - 1);
        System.out.println("median is " + median);
        return median;
    }

    private static int findMedianUtil(int[] arr, int middle_index, int low, int high) {
        int m = partition(arr, low, high);
        int length = m - low + 1;
        if (length == middle_index)
            return arr[m];

        if (length > middle_index)
            return findMedianUtil(arr, middle_index, low, m - 1);
        else
            return findMedianUtil(arr, middle_index - length, m + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = getPivotValue(arr, low, high);
        while (low < high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }

            if (arr[low] == arr[high])
                low++;

            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }

    private static int getPivotValue(int[] arr, int low, int high) {
        /*if (high - low + 1 <= 9) {
            Arrays.sort(arr);
            return arr[arr.length / 2];
        }*/
        if (high >= low)
            return high;

        int[] temp = null;
        int[] medians = new int[(int) Math.ceil((double) (high - low + 1) / 5)];
        int mediaIndex = 0;
        while (high >= low) {
            temp = new int[Math.min(5, high - low + 1)];
            for (int i = 0; i < temp.length && low <= high; i++) {
                temp[i] = arr[low];
                low++;
            }
            Arrays.sort(temp);
            medians[mediaIndex] = temp[temp.length / 2];
            mediaIndex++;
        }

        return getPivotValue(medians, 0, medians.length - 1);
    }
}

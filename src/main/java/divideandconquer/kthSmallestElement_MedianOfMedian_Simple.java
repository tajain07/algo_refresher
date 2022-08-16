package divideandconquer;

import java.util.Arrays;

public class kthSmallestElement_MedianOfMedian_Simple {
    public static void main(String[] args) {

        //-45 -18 10 17 19 25 25 33 35 40 41 51
        int[] arr = new int[]{17, 25, -45, 35, 51, -18, 33, 41, 19, 10, 40, 25};
        //int k = 2;
        int k = arr.length / 2;
        int kIndex = findMedian(arr, k);
        System.out.println("K'th smallest element is "
                + kIndex);
    }

    private static int findMedian(int[] arr, int k) {
        int median = findMedianUtil(arr, k, 0, arr.length - 1);
        return median;
    }

    private static int findMedianUtil(int[] arr, int k, int low, int high) {
        int m = partition(arr, low, high);
        int length = m - low + 1;

        if (length == k)
            return arr[m];

        if (length > k)
            return findMedianUtil(arr, k, low, m - 1);
        else
            return findMedianUtil(arr, k - length, m + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = getPivotValue(arr, low, high);
        while (low < high) {
            while (arr[low] < pivot)
                low++;
            while (arr[high] > pivot)
                high--;

            if (arr[low] == arr[high])
                low++;

                //swap
            else if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        return high;
    }

    private static int getPivotValue(int[] arr, int low, int high) {
        if (high - low + 1 < 9) {
            Arrays.sort(arr);
            return arr[arr.length / 2];
        }
        int[] temp = null;
        int[] medians = new int[(int) Math.ceil((double) (high - low + 1) / 5)];
        int medianIndex = 0;
        while (high >= low) {
            temp = new int[Math.min(5, high - low + 1)];
            for (int i = 0; i < temp.length && low <= high; i++) {
                temp[i] = arr[low];
                low++;
            }
            Arrays.sort(temp);
            medians[medianIndex] = temp[temp.length / 2];
            medianIndex++;
        }
        return getPivotValue(medians, 0, medians.length - 1);
    }

}

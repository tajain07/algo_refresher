package binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 */
public class PositionInAInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 22, 23, 30, 31, 32};
        int target = 15;
        int[] indices = findingRange(arr, target);
        int answer = binarySearch(arr, target, indices[0], indices[1]);
        System.out.println(answer);

    }

    private static int[] findingRange(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return new int[]{start, end};
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}

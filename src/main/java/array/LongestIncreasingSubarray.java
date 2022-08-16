package array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubarray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        int length = longestIncreasingSubArray(arr);
        System.out.println("Length " + length);
    }

    private static int longestIncreasingSubArray(int[] arr) {
        int max = 1, len = 1, maxIndex = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                if (max < len) {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }
        }

        if (max < len) {
            max = len;
            maxIndex = n - max;
        }

        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
        return max;
    }
}

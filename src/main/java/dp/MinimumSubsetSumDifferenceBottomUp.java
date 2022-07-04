package dp;

import java.util.Arrays;

public class MinimumSubsetSumDifferenceBottomUp {
    public static void main(String[] args) {
        //int[] arr = new int[]{1, 2, 7};
        int[] arr = new int[]{1, 6, 11, 5};
        int arr_sum = Arrays.stream(arr).sum();
        int mid = arr_sum / 2;
        int n = arr.length;
        boolean[] lastArray = subsetSum(arr, n, mid);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < lastArray.length; i++) {
            if (lastArray[i]) {
                int diff = arr_sum - 2 * i;

				minDiff = Math.min(minDiff, diff);
                //if (minDiff > diff)
                //    minDiff = diff;
            }
        }

        System.out.println("minDiff " + minDiff);


    }

    private static boolean[] subsetSum(int[] arr, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= sum; col++) {
                if (row == 0)
                    t[row][col] = false;
                if (col == 0)
                    t[row][col] = true;
            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= sum; col++) {
                int num = arr[row - 1];

                if (num > col)
                    t[row][col] = t[row - 1][col];
                else {
                    t[row][col] = t[row - 1][col] || t[row - 1][col - num];
                }
            }
        }

        return t[n];


    }
}
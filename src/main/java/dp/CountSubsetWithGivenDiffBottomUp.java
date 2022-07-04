package dp;

import java.util.Arrays;

public class CountSubsetWithGivenDiffBottomUp {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};
        int diff = 3;
        int arrSum = Arrays.stream(arr).sum();
        int sum = (arrSum - diff) / 2;

        int count = numberOfWaysToGetSubset(arr, arr.length, sum);
        System.out.println("count " + count);

    }

    private static int numberOfWaysToGetSubset(int[] arr, int n, int sum) {

        int[][] t = new int[n + 1][sum + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= sum; col++) {
                if (row == 0)
                    t[row][col] = 0;
                if (col == 0)
                    t[row][col] = 1;

            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= sum; col++) {
                int num = arr[row - 1];

                if (num > col)
                    t[row][col] = t[row - 1][col];
                else
                    t[row][col] = t[row - 1][col] + t[row - 1][col - num];

            }
        }

        return t[n][sum];
    }


}
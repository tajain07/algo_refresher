package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] val = new int[]{1, 30};
        int[] wt = new int[]{1, 50};
        int W = 100;

        int maxValue = maxValue(wt, val, W);
        System.out.println("maxValue " + maxValue);
    }

    private static int maxValue(int[] wt, int[] val, int W) {
        int n = wt.length;

        int[][] t = new int[n + 1][W + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= W; col++) {
                if (row == 0 || col == 0)
                    t[row][col] = 0;

            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= W; col++) {
                int curr_wt = wt[row - 1];
                int value = val[row - 1];

                if (curr_wt > col)
                    t[row][col] = t[row - 1][col];
                else
                    t[row][col] = Math.max(t[row - 1][col], value + t[row][col - curr_wt]);

            }
        }


        return t[n][W];

    }
}
package dp;

import java.util.Arrays;

public class KnapSack01BottomUp {

    private static int[][] t;

    public static void main(String[] args) {
        int[] val = new int[] { 10, 15, 40 };
        int[] wt = new int[] { 1, 2, 3 };
        int W = 6;

        t = new int[val.length + 1][W + 1];

        for (int[] subArray : t) {
            Arrays.fill(subArray, -1);
        }

        int maxValue = max(wt, val, val.length, W);
        System.out.println("maxvalue " + maxValue);

        for (int[] subArray : t) {
            System.out.println(Arrays.toString(subArray));
        }
    }

    private static int max(int[] wt, int[] val, int length, int w) {

        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]],
                            t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }

            }
        }
        return t[val.length][w];
    }
}

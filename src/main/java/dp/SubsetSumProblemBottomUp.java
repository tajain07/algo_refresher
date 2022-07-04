package dp;

import java.util.Arrays;

public class SubsetSumProblemBottomUp {

    private static boolean[][] t;

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 7, 8, 10};
        int sum = 14;

        t = new boolean[a.length + 1][sum + 1];

        for (boolean[] value : t) {
            Arrays.fill(value, false);
        }

        boolean value = isSubsetSum(a, a.length, sum);
        System.out.println(value);

        for (boolean[] valueNew : t) {
            System.out.println(Arrays.toString(valueNew));
        }
    }

    private static boolean isSubsetSum(int[] a, int n, int sum) {

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= sum; col++) {
                if (row == 0)
                    t[row][col] = false;

                //we give preference to true over false
                if (col == 0)
                    t[row][col] = true;

            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= sum; col++) {

                if (a[row - 1] <= col) {
                    t[row][col] = (t[row - 1][col] || t[row - 1][col - a[row - 1]]);

                } else {
                    t[row][col] = t[row - 1][col];
                }
            }
        }

        return t[n][sum];
    }
}

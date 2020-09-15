package dp;

import java.util.Arrays;

public class SubsetSumProblemBottomUp {

    private static boolean[][] t;

    public static void main(String[] args) {
        int[] a = new int[] { 1, 1, 2, 5, 3 };
        int sum = 6;

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

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;

                if (j == 0)
                    t[i][j] = true;

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (a[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j] || t[i -1][j - a[i - 1]]);

                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}

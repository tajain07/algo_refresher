package dp;

import java.util.Arrays;

public class CountOfSubsetsWithGivenSumBottomUp {

    private static int[][] t;

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;

        t = new int[a.length + 1][sum + 1];
        int count = subsetCountBottomUp(a, a.length, sum);
        System.out.println("subset count " + count);

        for (int[] subArray : t) {
            System.out.println(Arrays.toString(subArray));
        }

    }

    private static int subsetCountBottomUp(int[] a, int n, int sum) {

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {

                if (i == 0)
                    t[i][j] = 0;

                if (j == 0)
                    t[i][j] = 1;

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (a[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];

                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}

package dp;

import java.util.Arrays;

public class SubsetSumProblemMemoization {

    private static boolean[][] t;

    public static void main(String[] args) {
        int a[] = new int[] { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        t = new boolean[a.length + 1][sum + 1];

        for (boolean[] value : t) {
            Arrays.fill(value, false);
        }

        boolean value = isSubsetSum(a, a.length, sum);
        System.out.println(value);

        for (boolean[] valueNew : t){
            System.out.println(Arrays.toString(valueNew));
        }
    }

    private static boolean isSubsetSum(int[] a, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        if (t[n][sum]) {
            return true;
        }

        if (a[n - 1] <= sum) {
            t[n][sum] = isSubsetSum(a, n - 1, sum) || isSubsetSum(a, n - 1, sum - a[n - 1]);
        } else {
            t[n][sum] = isSubsetSum(a, n - 1, sum);
        }

        return t[n][sum];

    }
}

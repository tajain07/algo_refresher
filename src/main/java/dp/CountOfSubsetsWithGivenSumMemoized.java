package dp;

import java.util.Arrays;

public class CountOfSubsetsWithGivenSumMemoized {

    private static int[][] t;

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;

        t = new int[a.length + 1][sum + 1];
        int count = subsetCountMemoized(a, a.length, sum);
        System.out.println("subset count " + count);

        for(int[] subArray : t){
            System.out.println(Arrays.toString(subArray));
        }

    }

    private static int subsetCountMemoized(int[] a, int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        if (t[n][sum] > 0)
            return t[n][sum];

        if (a[n - 1] <= sum)
            t[n][sum] = subsetCountMemoized(a, n - 1, sum) + subsetCountMemoized(a, n - 1, sum - a[n - 1]);
        else
            t[n][sum] = subsetCountMemoized(a, n - 1, sum);

        return t[n][sum];
    }
}

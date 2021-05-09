package dp.knapsack_01;

import java.util.Arrays;

public class KnapSack01Memoized {

    static int[][] t;

    public static void main(String[] args) {
        int[] val = new int[] { 60, 100, 120 };
        int[] wt = new int[] { 10, 20, 30 };
        int W = 50;

        t = new int[val.length + 1][W + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }

        int value = knapSackUsingMemomization(wt, val, val.length, W);
        System.out.println("maximum value : " + value);

        System.out.println("t :");
        for (int[] arr : t) {
            System.out.println(Arrays.toString(arr));
        }

    }

    private static int knapSackUsingMemomization(int[] wt, int[] val, int n, int requiredWeight) {
        if (n == 0 || requiredWeight == 0)
            return 0;

        if (t[n][requiredWeight] != -1)
            return t[n][requiredWeight];

        if (wt[n - 1] <= requiredWeight) {
            t[n][requiredWeight] = Math.max(val[n - 1] + knapSackUsingMemomization(wt, val, n - 1, requiredWeight - wt[n - 1]),
                    knapSackUsingMemomization(wt, val, n - 1, requiredWeight));
        } else {
            t[n][requiredWeight] = knapSackUsingMemomization(wt, val, n - 1, requiredWeight);
        }
        return t[n][requiredWeight];

    }

}

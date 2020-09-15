package dp;

import java.util.Arrays;

public class EqualSumPartitionMemoized {

    private static boolean[][] t;

    public static void main(String[] args) {
        int[] a = new int[] { 1, 1, 2, 5, 3 };
        int sum = Arrays.stream(a).sum();
        int requiredSum = sum / 2;

        t = new boolean[a.length + 1][requiredSum + 1];
        System.out.println("sum " + sum + " requiredSum " + requiredSum);

        boolean result = false;

        if (sum % 2 == 0) {
            result = isEqualSumPartition(a, a.length, requiredSum);
        }

        System.out.println("isEqualSumPartition " + result);

        for (boolean[] arr : t) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static boolean isEqualSumPartition(int[] a, int n, int sum) {

        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (t[n][sum]) {
            return true;
        }

        if (a[n - 1] <= sum) {
            t[n][sum] = isEqualSumPartition(a, n - 1, sum) ||
                    isEqualSumPartition(a, n - 1, sum - a[n - 1]);
        } else {
            t[n][sum] = isEqualSumPartition(a, n - 1, sum);
        }

        return t[n][sum];
    }
}

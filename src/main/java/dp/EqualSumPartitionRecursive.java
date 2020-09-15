package dp;

import java.util.Arrays;

public class EqualSumPartitionRecursive {

    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 2, 6, 11, 6 };
        int sum = Arrays.stream(a).sum();
        int requiredSum = sum / 2;

        System.out.println("sum " + sum + " requiredSum " + requiredSum);

        boolean result = false;
        if (sum % 2 == 0) {

            result = isEqualSumPartition(a, a.length, requiredSum);
        }

        System.out.println("isEqualSumPartition " + result);

    }

    private static boolean isEqualSumPartition(int[] a, int n, int sum) {

        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (a[n - 1] <= sum) {
            return isEqualSumPartition(a, n - 1, sum) ||
                    isEqualSumPartition(a, n - 1, sum - a[n - 1]);
        } else {
            return isEqualSumPartition(a, n - 1, sum);
        }
    }
}

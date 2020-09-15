package dp;

import java.util.Arrays;

public class EqualSumPartitionBottomUp {

    private static boolean[][] t;

    public static void main(String[] args) {
        int[] a = new int[] { 2, 1, 2, 5, 3 };
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

    private static boolean isEqualSumPartition(int[] a, int length, int requiredSum) {

        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < requiredSum + 1; j++) {

                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < requiredSum + 1; j++) {

                if (a[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j] || t[i -1][j - a[i - 1]]);

                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[length][requiredSum];
    }
}

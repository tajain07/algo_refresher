package dp;

public class SubsetSumProblemRecursive {
    public static void main(String[] args) {
        int a[] = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 34;

        boolean value = isSubsetSum(a, a.length, sum);
        System.out.println(value);

    }

    private static boolean isSubsetSum(int[] a, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        if (a[n - 1] <= sum) {
            return isSubsetSum(a, n - 1, sum) || isSubsetSum(a, n - 1, sum - a[n - 1]);
        } else {
            return isSubsetSum(a, n - 1, sum);
        }

    }


}

package dp;

public class CountOfSubsetsWithGivenSumRecursive {
    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;

        int count = subsetCountRecursive(a, a.length, sum);
        System.out.println("count " + count);
    }

    private static int subsetCountRecursive(int[] a, int n, int sum) {

        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        if (a[n - 1] <= sum)
            return subsetCountRecursive(a, n - 1, sum) + subsetCountRecursive(a, n - 1, sum - a[n - 1]);
        else
            return subsetCountRecursive(a, n - 1, sum);
    }
}

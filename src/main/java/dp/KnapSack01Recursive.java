package dp;

public class KnapSack01Recursive {

    public static void main(String[] args) {

        int[] val = new int[] { 60, 100, 120 };
        int[] wt = new int[] { 10, 20, 30 };
        int W = 50;

        int value = knapsackRecursive(wt, val, val.length, W);
        System.out.println(value);
    }

    private static int knapsackRecursive(int[] wt, int[] val, int n, int requiredWeight) {
        if (n == 0 || requiredWeight == 0)
            return 0;

        if (wt[n - 1] <= requiredWeight) {
            return Math.max(val[n - 1] + knapsackRecursive(wt, val, n - 1, requiredWeight - wt[n - 1]),
                    knapsackRecursive(wt, val, n - 1, requiredWeight));
        } else {
            return knapsackRecursive(wt, val, n - 1, requiredWeight);
        }
    }
}

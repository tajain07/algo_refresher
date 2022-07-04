package dp;

public class MCMRecursive {
    public static void main(String[] args) {
        TestRunner.runTestCase(solveCore(new int[]{40, 20, 30, 10, 30}), 26000);
        TestRunner.runTestCase(solveCore(new int[]{1, 2, 3, 4}), 18);
        TestRunner.runTestCase(solveMySchemeCore(new int[]{1, 2, 3, 4}), 18);
    }

    public static int solveCore(int[] arr) {

        return solve(arr, 1, arr.length - 1);
    }

    private static int solve(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int currCost = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            minCost = Math.min(currCost, minCost);
        }

        return minCost;
    }


    public static int solveMySchemeCore(int[] arr) {

        return solveMyScheme(arr, 0, arr.length - 1);
    }

    private static int solveMyScheme(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j - 1; k++) {
            int a = solveMyScheme(arr, i, k + 1);
            int b = solveMyScheme(arr, k + 1, j);
            int c = arr[i] * arr[k + 1] * arr[j];
            //System.out.println(arr[i] + "" + arr[k + 1] + "" + arr[j]);
            int currCost = a + b + c;

            minCost = Math.min(currCost, minCost);

        }

        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }


}

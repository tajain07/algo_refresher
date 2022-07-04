package dp;

import java.util.Arrays;

//Revisit again
//Not clear
//TODO = DRY RUN
public class CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = new int[]{3, 2, 1, 1};
        int sum = 5;

        int minWays = minNumberOfCoins(coins, coins.length, sum);
        System.out.println("minWays " + minWays);

    }

    private static int minNumberOfCoins(int[] coins, int n, int sum) {

        if (n == 0)
            return -1;
        if (sum == 0)
            return 0;

        int[][] t = new int[n + 1][sum + 1];

		//Why - t[row][col] = Integer.MAX_VALUE - 1
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= sum; col++) {


                if (col == 0)
                    t[row][col] = 0;

                if (row == 0)
                    t[row][col] = Integer.MAX_VALUE - 1;

            }
        }


		//Why - initalizing 2nd row
		for (int col = 1; col <= sum; col++) {
            if (col % coins[0] == 0)
                t[1][col] = col / coins[0];
            else
                t[1][col] = Integer.MAX_VALUE - 1;
        }


        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= sum; col++) {

                int current_coin = coins[row - 1];

                if (current_coin > col)
                    t[row][col] = t[row - 1][col];
                else
                    t[row][col] = Math.min(t[row - 1][col], t[row][col - current_coin] + 1);

            }
        }

        int res = t[n][sum];

        if (res >= Integer.MAX_VALUE - 1)
            return -1;
        else
            return res;

    }

}
package dp;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,1};
        int diff = 1;
        int arrSum = Arrays.stream(arr).sum();
        float sum = (arrSum + diff);
        sum = sum / 2;


        int count = 0;
        if (sum % 1 == 0)
            count = numberOfWaysToGetSubset(arr, arr.length, (int) sum);


        System.out.println("count " + count);

    }

    private static int numberOfWaysToGetSubset(int[] arr, int n, int sum) {


        int c = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] == 0)
                c++;

        int[][] t = new int[n + 1][sum + 1];


        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= sum; col++) {
                if (row == 0)
                    t[row][col] = 0;
                if (col == 0)
                    t[row][col] = 1;

            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= sum; col++) {
                int num = arr[row - 1];

                if (num > col || num == 0)
                    t[row][col] = t[row - 1][col];
                else
                    t[row][col] = t[row - 1][col] + t[row - 1][col - num];

            }
        }

        System.out.println(t[n][sum]);;
        return (int) (Math.pow(2,c)*t[n][sum]);

    }


}
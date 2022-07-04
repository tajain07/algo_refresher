package dp;

import java.util.Arrays;

public class LCS_Bottomup_DP {
    public static void main(String[] args) {
        String x = "abcdef";
        String y = "abd";

        int count = lcsBottomUp(x, x.length(), y, y.length());
        System.out.println("count " + count);

    }

    public static int lcsBottomUp(String x, int xlen, String y, int ylen) {
        int[][] t = new int[xlen + 1][ylen + 1];

        for (int row = 0; row <= xlen; row++) {
            for (int col = 0; col <= ylen; col++) {
                if (row == 0 || col == 0)
                    t[row][col] = 0;
            }
        }

        for (int row = 1; row <= xlen; row++) {
            for (int col = 1; col <= ylen; col++) {
                if (x.charAt(row - 1) == y.charAt(col - 1))
                    t[row][col] = 1 + t[row - 1][col - 1];
                else
                    t[row][col] = Math.max(t[row][col - 1], t[row - 1][col]);
            }
        }

        return t[xlen][ylen];
    }
}
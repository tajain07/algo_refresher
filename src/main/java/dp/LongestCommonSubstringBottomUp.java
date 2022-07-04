package dp;

import java.util.Arrays;

public class LongestCommonSubstringBottomUp {
    public static void main(String[] args) {
        String x = "abcd";
        String y = "abce";


        int count_temp = lcs_count(x, x.length(), y, y.length());
        System.out.println("count_temp " + count_temp);
    }

    // time complexity = o(m*n)
    // space complexity = o(m*n)
    private static int lcs_count(String x, int x_len, String y, int y_len) {
        int[][] t = new int[x_len + 1][y_len + 1];
        int result = 0;

        for (int row = 0; row <= x_len; row++) {
            for (int col = 0; col <= y_len; col++) {
                if (row == 0 || col == 0)
                    t[row][col] = 0;

                else if (x.charAt(row - 1) == y.charAt(col - 1)) {
                    t[row][col] = 1 + t[row - 1][col - 1];
                    result = Math.max(result, t[row][col]);
                } else {
                    t[row][col] = 0;
                }
            }
        }

        return result;

    }


}

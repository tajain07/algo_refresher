package dp;

import java.util.Arrays;

public class LongestCommonSubstringMemo {
    public static void main(String[] args) {
        String x = "abcd";
        String y = "abce";

        int[][] t = new int[x.length() + 1][y.length() + 1];
        for (int[] t_run : t)
            Arrays.fill(t_run, -1);

        int count_temp = lcs_count(x, x.length(), y, y.length(), t, 0);
        System.out.println("count_temp " + count_temp);
    }

    // time complexity = ?
    // space complexity = ?
    private static int lcs_count(String x, int x_len, String y, int y_len, int[][] t, int count) {


        if (x_len == 0 || y_len == 0)
            return count;

        if (t[x_len][y_len] != -1)
            return t[x_len][y_len];

        int lcsCount = count;
        if (x.charAt(x_len - 1) == y.charAt(y_len - 1)) {
            lcsCount = lcs_count(x, x_len - 1, y, y_len - 1, t, count + 1);
        }

        int lcsCountTemp1 = lcs_count(x, x_len - 1, y, y_len, t, 0);
        int lcsCountTemp2 = lcs_count(x, x_len, y, y_len - 1, t, 0);

        return Math.max(lcsCount, Math.max(lcsCountTemp1, lcsCountTemp2));

    }
}

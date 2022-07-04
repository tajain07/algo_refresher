package dp;

import java.util.Arrays;

public class LCS_Recursive_Memo {
    public static void main(String[] args) {
        String x = "acdef";
        String y = "abdf";

        int[][] t = new int[x.length() + 1][y.length() + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }


        int count = lcs_count(x, x.length() - 1, y, y.length() - 1, t);
        System.out.println("count " + count);
    }

    private static int lcs_count(String x, int x_len, String y, int y_len, int[][] t) {
        if (x_len == 0 || y_len == 0)
            return 0;

        if (t[x_len][y_len] != -1)
            return t[x_len][y_len];

        System.out.println("lcs_count called");


        if (x.charAt(x_len) == y.charAt(y_len)) {
            return t[x_len][y_len] = 1 + lcs_count(x, x_len - 1, y, y_len - 1, t);

        } else {
            return t[x_len][y_len] = Math.max(lcs_count(x, x_len - 1, y, y_len, t), lcs_count(x, x_len, y, y_len - 1, t));

        }
    }

}

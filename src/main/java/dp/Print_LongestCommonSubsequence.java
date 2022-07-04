package dp;

public class Print_LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "abcxde";
        String y = "xascke";

        printLCSRunner(x, y);

    }

    public static String printLCSRunner(String x, String y) {
        int[][] t = new int[x.length() + 1][y.length() + 1];

        int count = lcs(x, x.length(), y, y.length(), t);
        //System.out.println("count " + count);
        return printLCS(t, x, x.length(), y, y.length());
    }

    public  static String printLCS(int[][] t, String x, int x_len, String y, int y_len) {
        int i = x_len, j = y_len;
        StringBuilder lcs_str = new StringBuilder();

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs_str.append(x.charAt(i - 1));
                i--;
                j--;

            } else {
                if (t[i - 1][j] > t[i][j - 1])
                    i--;
                else
                    j--;

            }
        }

        lcs_str.reverse();
        //System.out.println("lcs_str " + lcs_str);
		return lcs_str.toString();
    }


    public static int lcs(String x, int x_len, String y, int y_len, int[][] t) {
        for (int row = 0; row <= x_len; row++) {
            for (int col = 0; col <= y_len; col++) {
                if (row == 0 || col == 0)
                    t[row][col] = 0;

                else if (x.charAt(row - 1) == y.charAt(col - 1)) {
                    t[row][col] = t[row - 1][col - 1] + 1;
                } else {
                    t[row][col] = Math.max(t[row - 1][col], t[row][col - 1]);
                }
            }
        }

        return t[x_len][y_len];

    }
}
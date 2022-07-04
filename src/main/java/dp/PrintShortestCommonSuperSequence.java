package dp;

public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "abcdaf";
        String y = "acbcf";

        String shortestCommonSupersequence = printShortestCommonSupersequenceRunner(x, y);
        System.out.println("shortestCommonSupersequence " + shortestCommonSupersequence);
    }

    private static String printShortestCommonSupersequenceRunner(String x, String y) {
        int[][] t = new int[x.length() + 1][y.length() + 1];

        int count = Print_LongestCommonSubsequence.lcs(x, x.length(), y, y.length(), t);
        System.out.println("count " + count);
        System.out.println("LCS " + Print_LongestCommonSubsequence.printLCS(t, x, x.length(), y, y.length()));
        return printSCS(t, x, x.length(), y, y.length());
    }

    private static String printSCS(int[][] t, String x, int x_len, String y, int y_len) {
        int i = x_len, j = y_len;
        StringBuilder lcs_str = new StringBuilder("]");

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs_str.append(x.charAt(i - 1));
                i--;
                j--;

            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    lcs_str.append(x.charAt(i - 1));
                    i--;
                } else {
                    lcs_str.append(y.charAt(j - 1));
                    j--;
                }

            }
        }

        lcs_str.append("[");
        lcs_str.reverse();
        System.out.println("lcs_str " + lcs_str);
        return lcs_str.toString();
    }
}

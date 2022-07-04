package dp;

public class LCS_Recursive {
    public static void main(String[] args) {
        String x = "abcdef";
        String y = "abdf";

        int count = lcs_count(x, x.length() - 1, y, y.length() - 1);
        System.out.println("count " + count);
    }

    private static int lcs_count(String x, int x_len, String y, int y_len) {
        if (x_len == 0 || y_len == 0)
            return 0;
        System.out.println("lcs_count called");

        if (x.charAt(x_len) == y.charAt(y_len))
            return 1 + lcs_count(x, x_len - 1, y, y_len - 1);
        else
            return Math.max(lcs_count(x, x_len - 1, y, y_len), lcs_count(x, x_len, y, y_len - 1));
    }

}

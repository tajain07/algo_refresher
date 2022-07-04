package dp;

public class LongestCommonSubstringRecursive {
    public static void main(String[] args) {
        String x = "abcd";
        String y = "abce";

        int count_temp = lcs_count(x, x.length(), y, y.length(), 0);
        System.out.println("count_temp " + count_temp);
    }

    // time complexity = O(3^(m+n))
    // space complexity = O(m+n)
    private static int lcs_count(String x, int x_len, String y, int y_len, int count) {


        if (x_len == 0 || y_len == 0)
            return count;

        int lcsCount = count;
        if (x.charAt(x_len - 1) == y.charAt(y_len - 1)) {
            lcsCount = lcs_count(x, x_len - 1, y, y_len - 1, count + 1);
        }

        int lcsCountTemp1 = lcs_count(x, x_len - 1, y, y_len, 0);
        int lcsCountTemp2 = lcs_count(x, x_len, y, y_len - 1, 0);

        return Math.max(lcsCount, Math.max(lcsCountTemp1, lcsCountTemp2));

    }
}

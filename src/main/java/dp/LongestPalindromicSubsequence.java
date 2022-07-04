package dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "agbcba";

        String ans = longestPalindromicSubsequence(x);
        System.out.println("ans " + ans);

    }

    public static String longestPalindromicSubsequence(String x) {
        String y = new StringBuilder(x).reverse().toString();

        String lcs = Print_LongestCommonSubsequence.printLCSRunner(x, y);

        return lcs;
    }


}

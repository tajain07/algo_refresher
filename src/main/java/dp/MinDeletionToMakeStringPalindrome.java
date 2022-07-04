package dp;

public class MinDeletionToMakeStringPalindrome {
    public static void main(String[] args) {
        String x = "agbcba";

        String ans = LongestPalindromicSubsequence.longestPalindromicSubsequence(x);
        System.out.println("ans " + ans);
        System.out.println("Min deletion "+(x.length()-ans.length()));
    }
}

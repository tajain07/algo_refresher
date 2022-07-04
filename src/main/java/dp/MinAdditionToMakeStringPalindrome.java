package dp;

public class MinAdditionToMakeStringPalindrome {
    public static void main(String[] args) {
        String x = "agbcba";


        TestRunner.runTestCase(MinAdditionToMakeStringPalindrome.minAdditionToMakeStringPalindrom("agbcba"), 1);
        TestRunner.runTestCase(MinAdditionToMakeStringPalindrome.minAdditionToMakeStringPalindrom("abcde"), 4);
        TestRunner.runTestCase(MinAdditionToMakeStringPalindrome.minAdditionToMakeStringPalindrom("geeks"), 3);


    }

    public static int minAdditionToMakeStringPalindrom(String x) {
        String ans = LongestPalindromicSubsequence.longestPalindromicSubsequence(x);
        //System.out.println("ans " + ans);
        int result = x.length() - ans.length();
        return result;
    }
}

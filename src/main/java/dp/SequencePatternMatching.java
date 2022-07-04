package dp;

public class SequencePatternMatching {
    public static void main(String[] args) {

        TestRunner.runTestCase(isStringASubSequenceOfB("AXY", "ADXCPY"), true);
        TestRunner.runTestCase(isStringASubSequenceOfB("AXYZ", "ADXCPY"), false);

    }

    public static boolean isStringASubSequenceOfB(String a, String b) {
        int lcs_len = LCS_Bottomup_DP.lcsBottomUp(a, a.length(), b, b.length());
        if (lcs_len == a.length())
            return true;

        return false;
    }
}

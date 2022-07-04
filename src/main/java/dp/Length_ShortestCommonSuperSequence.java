package dp;

public class Length_ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "eke";
        //Output: "geeke"
        int count = lengthOfShortestCommonSubsequence(str1, str1.length(), str2, str2.length());
        System.out.println("count " + count);
    }

    private static int lengthOfShortestCommonSubsequence(String x, int x_len, String y, int y_len) {
        int lcs_size = LCS_Bottomup_DP.lcsBottomUp(x, x_len, y, y_len);
        return x_len + y_len - lcs_size;
    }
}


package dp;

//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
//https://www.geeksforgeeks.org/miimum-number-deletions-insertions-transform-one-string-another/
public class MinimumNumberOfInsertionDeletionToConvertAtoB {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";

        int minDel = minDeletion(x, x.length(), y, y.length());
        int minAdd = minAddition(x, x.length(), y, y.length());
        System.out.println("minDel "+minDel+"\nminAdd "+minAdd);
    }

    private static int minAddition(String x, int x_len, String y, int y_len) {
        int lcsCount = LCS_Bottomup_DP.lcsBottomUp(x, x_len, y, y_len);
        return y.length() - lcsCount;
    }

    private static int minDeletion(String x, int x_len, String y, int y_len) {
        int lcsCount = LCS_Bottomup_DP.lcsBottomUp(x, x_len, y, y_len);
        return x.length() - lcsCount;
    }
}

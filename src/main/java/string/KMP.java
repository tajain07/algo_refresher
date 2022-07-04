package string;

import org.junit.Assert;

public class KMP {
    public static void main(String[] args) {

        //LPS runs + testcase

        String[] patterns = new String[]{"abcdabeabf", "abcdeabfabc", "aabcadaabe", "aaaabaacd"};
        int[][] lps_expected = new int[][]{{0, 0, 0, 0, 1, 2, 0, 1, 2, 0}, {0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 3}, {0, 1, 0, 0, 1, 0, 1, 2, 3, 0}, {0, 1, 2, 3, 0, 1, 2, 0, 0}};

        for (int i = 0; i < patterns.length; i++) {
            int[] lpsTable = lps(patterns[i]);
            int[] expectedOutput = lps_expected[i];
            Assert.assertArrayEquals(expectedOutput, lpsTable);
            //System.out.println(Arrays.toString(lpsTable));
        }

        //Actual KMP run
        String str = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        final int[] lps_found = lps(pattern);

        int index = kmp(str, pattern, lps_found);

        System.out.println("index = " + index);
    }

    private static int kmp(String str, String pattern, int[] lps_found) {
        int i = 0, j = 0;
        for (; i < str.length() && j < pattern.length(); i++) {
            if (str.charAt(i) == pattern.charAt(j))
                j++;
            else if (j > 0)
                j = backtrackUsingLPS(str, i, pattern, lps_found, j - 1);
        }

        if (j == pattern.length()) {
            return i - pattern.length();
        }

        return -1;
    }

    private static int backtrackUsingLPS(String str, int i, String pattern, int[] lps_found, int j) {
        while (j != 0) {
            //since last character was matching..
            //check if we have a substring with matching characters
            j = lps_found[j];

            if (str.charAt(i) == pattern.charAt(j)) {
                return j + 1;
            }
        }

        return j;
    }


    private static int[] lps(String pattern) {
        int[] lpsTable = new int[pattern.length()];

        final char[] chars = pattern.toCharArray();
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[j]) {
                lpsTable[i] = j + 1;
                j++;
            } else {
                j = 0;
            }

        }

        return lpsTable;
    }
}

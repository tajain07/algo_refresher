package dp;


public class LongestRepeatingSubsequence {
    public static void main(String[] args) {

        //String str = "aabb";
        //String str = "AABEBCDD";

        //int[][] t = lengthOfLongestRepeatingSubsequence("aabb");
        //System.out.println("lengthOfLongestRepeatingSubsequence " + t[str.length()][str.length()]);

        TestRunner.runTestCase(longestRepeatingSubsequence("aabb"), "ab");
		TestRunner.runTestCase(longestRepeatingSubsequence("AABEBCDD"), "ABD");
		TestRunner.runTestCase(longestRepeatingSubsequence("AABEBCDD"), "ABDD");


    }




    public static String longestRepeatingSubsequence(String s) {
        int[][] t = lengthOfLongestRepeatingSubsequence(s);
        int i = s.length();
        int j = s.length();

        StringBuilder foundSeq = new StringBuilder();

        while (i > 0 && j > 0) {

            if (i != j && s.charAt(i - 1) == s.charAt(j - 1)) {
                foundSeq.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                //System.out.println("else if{t[i-1][j] > t[i][j-1]");
                i--;
            } else {
                j--;
            }

        }

        foundSeq.reverse();
        return foundSeq.toString();
    }


	public static int[][] lengthOfLongestRepeatingSubsequence(String s) {
		int[][] t = new int[s.length() + 1][s.length() + 1];

		for (int row = 0; row <= s.length(); row++) {
			for (int col = 0; col <= s.length(); col++) {

				if (row == 0 || col == 0)
					t[row][col] = 0;
				else if (row != col && s.charAt(row - 1) == s.charAt(col - 1)) {
					t[row][col] = t[row - 1][col - 1] + 1;
				} else {
					t[row][col] = Math.max(t[row - 1][col], t[row][col - 1]);
				}

			}
		}

		return t;

	}

}
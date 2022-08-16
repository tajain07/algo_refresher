package sliding_window.variable_size_sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description: https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will
 * always be only one unique minimum window in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * <p>
 * TODO - Complexity of this algorithm?
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "totmtapta";
        String t = "tta";
        String windowLength = minWondowSubString(s, t);
        System.out.println("windowLength " + windowLength);
    }

    private static String minWondowSubString(String s, String t) {
        Map<Character, Integer> tStringCharCountMap = new HashMap<>();

        for (Character c : t.toCharArray()) {
            tStringCharCountMap.put(c, tStringCharCountMap.getOrDefault(c, 0) + 1);
        }


        int i = 0, j = 0, k = tStringCharCountMap.size(), countOfUniqueCharacter = tStringCharCountMap.size(), minWindowLength = Integer.MAX_VALUE, iValue = -1, jValue = -1;

        while (j < s.length()) {
            final char charAtJ = s.charAt(j);

            if (tStringCharCountMap.containsKey(charAtJ)) {
                final int countCharAtJ = tStringCharCountMap.get(charAtJ) - 1;

                if (countCharAtJ == 0)
                    countOfUniqueCharacter--;

                tStringCharCountMap.put(charAtJ, countCharAtJ);

            }

            while (countOfUniqueCharacter == 0) {
                if (minWindowLength > j - i + 1) {
                    minWindowLength = j - i + 1;
                    iValue = i;
                    jValue = j;
                }


                final char charAtI = s.charAt(i);

                //if character in map, then collect it back and increase its count
                if (tStringCharCountMap.containsKey(charAtI)) {
                    final int countCharAtI = tStringCharCountMap.get(charAtI) + 1;
                    if (countCharAtI > 0) {
                        countOfUniqueCharacter++;
                    }
                    tStringCharCountMap.put(charAtI, countCharAtI);
                }

                i++;
            }
            j++;
        }

        if (iValue == -1)
            return "<not found>";
        return s.substring(iValue, jValue + 1);
    }


}

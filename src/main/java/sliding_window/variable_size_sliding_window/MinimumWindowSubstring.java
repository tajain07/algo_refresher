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
 *
 * TODO - Complexity of this algorithm?
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        String windowLength = minWondowSubString(s, t);
        System.out.println("windowLength " + windowLength);
    }

    private static String minWondowSubString(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int i = 0, j = 0, k = map.size(), countOfUniqueCharacter = map.size(), minWindowLength = Integer.MAX_VALUE, iValue = -1, jValue = -1;

        while (j < s.length()) {
            final char charAtJ = s.charAt(j);

            if (map.containsKey(charAtJ)) {
                final int countCharAtJ = map.get(charAtJ) - 1;

                if (countCharAtJ == 0)
                    countOfUniqueCharacter--;

                map.put(charAtJ, countCharAtJ);

            }

            while (countOfUniqueCharacter == 0) {
                if (minWindowLength > j - i + 1) {
                    minWindowLength = j - i + 1;
                    iValue = i;
                    jValue = j;
                }


                final char charAtI = s.charAt(i);
                if (map.containsKey(charAtI)) {
                    final int countCharAtI = map.get(charAtI) + 1;
                    if (countCharAtI > 0) {
                        countOfUniqueCharacter++;
                    }
                    map.put(charAtI, countCharAtI);
                }

                i++;
            }
            j++;
        }

        if (iValue == -1)
            return "";
        return s.substring(iValue, jValue + 1);
    }


}

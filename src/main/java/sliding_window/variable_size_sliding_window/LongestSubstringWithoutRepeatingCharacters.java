package sliding_window.variable_size_sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.


Example:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        final int output = lengthOfLongestSubstring(s);
        System.out.println("output " + output);

    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxWindowLength = 0, numOfUniqueCharacter = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        while (j < s.length()) {
            final char charAtJ = s.charAt(j);
            final Integer value = charCountMap.getOrDefault(charAtJ, 0);
            if (value == 0) {
                numOfUniqueCharacter++;
            }
            charCountMap.put(charAtJ, value + 1);

            if (numOfUniqueCharacter == j - i + 1) {
                maxWindowLength = Math.max(maxWindowLength, j - i + 1);
                System.out.println("maxWindowLength = " + maxWindowLength + " j = " + j + " i = " + i);
            } else if (numOfUniqueCharacter < j - i + 1) {
                while (numOfUniqueCharacter < j - i + 1) {
                    final char charAtI = s.charAt(i);
                    final int valueAtI = charCountMap.get(charAtI) - 1;
                    if (valueAtI == 0) {
                        charCountMap.remove(charAtI);
                        numOfUniqueCharacter--;
                    } else {
                        charCountMap.put(charAtI, valueAtI);
                    }

                    i++;
                }
            }


            j++;
        }

        return maxWindowLength;

    }
}

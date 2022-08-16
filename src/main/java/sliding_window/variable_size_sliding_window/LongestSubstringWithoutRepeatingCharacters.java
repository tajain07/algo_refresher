package sliding_window.variable_size_sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        final int i = maxWindowSizeForNonCharacters(s);
        System.out.println(i);

    }


    public static int maxWindowSizeForNonCharacters(String s) {

        char[] arr = s.toCharArray();
        int maxWindowSize = 0, i = 0, j = 0, n = arr.length;
        Map<Character, Integer> charCountMap = new HashMap<>();
        Set<Character> repeatingCharacters = new HashSet<>();

        while (j < n) {

            char c = arr[j];
            int currentCount = charCountMap.getOrDefault(c, 0);
            if (currentCount > 0)
                repeatingCharacters.add(c);
            charCountMap.put(c, ++currentCount);

            if (repeatingCharacters.size() == 0) {
                maxWindowSize = Math.max(j - i + 1, maxWindowSize);
            } else if (repeatingCharacters.size() > 0) {

                while (repeatingCharacters.size() > 0 && i <= j) {
                    char charAtI = arr[i++];
                    int count = charCountMap.get(charAtI);
                    int newCount = count - 1;
                    charCountMap.put(charAtI, newCount);
                    if (newCount <= 1 && repeatingCharacters.contains(charAtI))
                        repeatingCharacters.remove(charAtI);
                }
            }
            j++;
        }

        return maxWindowSize;

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
                //System.out.println("maxWindowLength = " + maxWindowLength + " j = " + j + " i = " + i);
            } else if (numOfUniqueCharacter < j - i + 1) {
                while (numOfUniqueCharacter < j - i + 1) {
                    final char charAtI = s.charAt(i);
                    final int valueAtI = charCountMap.getOrDefault(charAtI, 0) - 1;
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

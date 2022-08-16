package sliding_window.variable_size_sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
    https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

    Given a string you need to print the size of the longest possible substring that has exactly k unique characters.


    Example:
    Input:
    2
    aabacbebebe
    3
    aaaa
    1
    Output:
    7
    4
 */
public class LongestSubStringWithKUniqueCharacters {
    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        int result = longestkSubstr(S, K);
        System.out.println("result " + result);

        result = maxWindowSizeForKUniqueCharacters(S.toCharArray(), K);
        System.out.println("result " + result);
    }

    // 4 1 1 1 2 3 5, sum = 4
    public static int maxWindowSizeForKUniqueCharacters(char[] arr, int k) {

        int maxWindowSize = 0, i = 0, j = 0, n = arr.length;
        Map<Character, Integer> charCountMap = new HashMap<>();


        while (j < n) {

            char c = arr[j];
            int currentCount = charCountMap.getOrDefault(c, 0);
            charCountMap.put(c, ++currentCount);

            if (charCountMap.size() == k) {
                maxWindowSize = Math.max(j - i + 1, maxWindowSize);
            } else if (charCountMap.size() > k) {
                {
                    while (charCountMap.size() > k) {
                        char chatAtI = arr[i++];
                        int count = charCountMap.get(chatAtI) - 1;
                        if (count == 0)
                            charCountMap.remove(chatAtI);
                        else
                            charCountMap.put(chatAtI, count);
                    }
                }

            }
            j++;


        }
        return maxWindowSize;

    }

    public static int longestkSubstr(String s, int k) {
        int i = 0, j = 0, maxWindowSize = -1, uniqueCharCount = 0;
        Map<Character, Integer> characterCountMap = new HashMap<>();

        while (j < s.length()) {

            final char charAtJ = s.charAt(j);
            final Integer currentCount = characterCountMap.getOrDefault(charAtJ, 0);
            characterCountMap.put(charAtJ, currentCount + 1);

            uniqueCharCount = characterCountMap.size();


            while (uniqueCharCount > k) {
                final char charAtI = s.charAt(i);
                // we may not need this if condition - as character at index i will always be in the map
                if (characterCountMap.containsKey(charAtI)) {
                    final Integer charAtICharCount = characterCountMap.get(charAtI);
                    if (charAtICharCount == 1) {
                        characterCountMap.remove(charAtI);
                    } else {
                        characterCountMap.put(charAtI, charAtICharCount - 1);
                    }
                }
                i++;
                uniqueCharCount = characterCountMap.size();
            }
            if (uniqueCharCount == k) {
                maxWindowSize = Math.max(maxWindowSize, j - i + 1);
                //System.out.println("maxWindowSize "+maxWindowSize +" j = " + j + " i = " + i);
            }
            j++;
        }

        return maxWindowSize;
    }
}

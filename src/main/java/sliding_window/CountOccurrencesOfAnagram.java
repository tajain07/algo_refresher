package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
 * Anagram - same words can be jumbled form
 * aab is anagram of aba
 */
public class CountOccurrencesOfAnagram {

    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String p = "for";
        int count = countOfAnagramsBruteForce(s, p);
        System.out.println("count " + count);

        count = countOfAnagrams_approach1(s, p);
        System.out.println("count " + count);

        count = countAnagram_approach2_usingMap2(s, p);
        System.out.println("count " + count);
    }

    private static int countOfAnagramsBruteForce(String s, String p) {
        int n = s.length();
        int m = p.length();

        int count = 0;
        int[] charCountForP = new int[26];

        for (int k = 0; k < m; k++) {
            final char c = p.charAt(k);
            charCountForP[c - 'a'] = charCountForP[c - 'a'] + 1;
        }
        for (int i = 0; i < n; i++) {
            int[] charCountForS = new int[26];

            for (int j = i; j < n && j < m + i; j++) {
                final char c = s.charAt(j);
                charCountForS[c - 'a']++;
            }
            if (Arrays.equals(charCountForS, charCountForP)) count += 1;

        }
        return count;
    }


    private static int countOfAnagrams_approach1(String s, String p) {
        int patternLength = p.length();
        int[] patternCount = new int[26];
        int[] sourceCount = new int[26];

        for (char ch : p.toCharArray()) {
            patternCount[ch - 'a'] += 1;
        }

        int len = 0;
        int count = 0;
        final char[] sourceChars = s.toCharArray();
        for (int i = 0; i < sourceChars.length; i++) {
            if (len < p.length()) {
                sourceCount[sourceChars[i] - 'a'] += 1;
                len++;
            } else {
                char charToRemove = sourceChars[i - patternLength];
                sourceCount[charToRemove - 'a'] -= 1;
                sourceCount[sourceChars[i] - 'a'] += 1;
            }

            if (Arrays.equals(patternCount, sourceCount)) count += 1;

        }
        return count;
    }


    private static int countAnagram_approach2_usingMap2(String txt, String pat) {

        int n = txt.length();
        int k = pat.length();
        int result = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            char charAtI = pat.charAt(i);
            int exisitingCharCount = charCountMap.getOrDefault(charAtI, 0);
            int newCharCount = exisitingCharCount + 1;
            charCountMap.put(charAtI, newCharCount);
            if (exisitingCharCount == 0)
                count++;
        }

        int j = 0;
        int i = 0;
        while (j < n) {
            char txtCharAtJ = txt.charAt(j);


            if (charCountMap.containsKey(txtCharAtJ)) {
                int charCount = charCountMap.get(txtCharAtJ);
                int newCharCount = charCount - 1;
                charCountMap.put(txtCharAtJ, newCharCount);
                if (newCharCount == 0)
                    count--;
            }

            if (j - i + 1 == k) {
                if (count == 0) result++;
                char charToBeOutOfWindow = txt.charAt(i);

                if (charCountMap.containsKey(charToBeOutOfWindow)) {
                    int exisitingCharCount = charCountMap.getOrDefault(charToBeOutOfWindow, 0);
                    int newCount = exisitingCharCount + 1;
                    charCountMap.put(charToBeOutOfWindow, newCount);
                    if (exisitingCharCount == 0) count++;
                }
                i++;
            }

            j++;
        }
        return result;
    }

}

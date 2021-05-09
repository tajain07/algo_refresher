package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
/*
    Input:
    txt = forxxorfxdofr
    pat = for
    Output: 3
    Explanation: for, orf and ofr appears
    in the txt, hence answer is 3.

    Input:
    txt = aabaabaa
    pat = aaba
    Output: 4
    Explanation: aaba is present 4 times
    in txt.
 */
public class CountAnagramsApproach2 {
    public static void main(String[] args) {
        String txt = "aabaabaa";
        String pat = "aaba";
        int count = countAnagram(pat, txt);
        System.out.println("count " + count);
    }

    /**
     * @param pat - pattern  - aabaabaa
     * @param txt - text - aaba
     * @return
     */
    private static int countAnagram(String pat, String txt) {
        int result = 0, j = 0, i = 0, k = pat.length();

        Map<Character, Integer> characterCountMap = new HashMap<>();

        //Prepeare map with count of each character
        //a - 3
        //b - 1
        for (Character ch : pat.toCharArray()) {
            characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
        }

        int count = characterCountMap.size();


        while (j < txt.length()) {
            Character textChar = txt.charAt(j);
            //If character at [j] is in original pattern
            //decrement count of the char from countMap +
            //if new count of char is 0 then decrement count as well.
            if (characterCountMap.containsKey(textChar)) {
                final int charCount = characterCountMap.get(textChar) - 1;
                characterCountMap.put(textChar, charCount);
                count = (charCount == 0) ? (count - 1) : count;
            }


            // If length between and i and j is equal to window
            if (j - i + 1 == k) {
                result = (count == 0) ? result + 1 : result;

                // character moving out of window if present in map
                // should be added to map + increment count
                Character charOutOfWindow = txt.charAt(i);
                if (characterCountMap.containsKey(charOutOfWindow)) {
                    final int outCharCount = characterCountMap.get(charOutOfWindow) + 1;
                    characterCountMap.put(charOutOfWindow, outCharCount);
                    count = (outCharCount > 0) ? (count + 1) : count;
                }
                i++;
            }
            j++;
        }
        return result;


    }
}

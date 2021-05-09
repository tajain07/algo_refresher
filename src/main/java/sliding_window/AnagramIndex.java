package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramIndex {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> count = findAnagrams(s, p);
        System.out.println("count " + count);
    }


    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndex = new ArrayList<>();
        int[] sourceCount = new int[26];
        int[] destCount = new int[26];

        for (char ch : p.toCharArray()) {
            sourceCount[ch - 'a'] += 1;
        }

        int len = 0;
        int count = 0;
        final char[] destChars = s.toCharArray();
        for (int i = 0; i < destChars.length; i++) {
            if (len < p.length()) {
                destCount[destChars[i] - 'a'] += 1;
                len++;

            } else {
                char charToRemove = destChars[i - p.length()];
                destCount[charToRemove - 'a'] -= 1;
                destCount[destChars[i] - 'a'] += 1;
            }

            if (Arrays.equals(sourceCount, destCount)) {
                anagramIndex.add(i - p.length() + 1);
            }

        }
        return anagramIndex;
    }
}

package sliding_window.variable_size_sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * John is at a toy store help him pick maximum number of toys.
 * He can only select in a continuous manner and he can select only two types of toys.
 * <p>
 * <p>
 * Example:
 * Input:
 * 1
 * abaccab
 * <p>
 * Output: max number of toys
 * <p>
 * Largest Substring with K unique character - check LongestSubStringWithKUniqueCharacters
 */
public class PickToys {
    public static void main(String[] args) {
        String str = "abaccab";
        int k = 2; //max two type allowed

        int toyCount = maxNumberOfToys(str, k);
        System.out.println("toyCount " + toyCount);
    }

    private static int maxNumberOfToys(String str, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int i = 0, j = 0, n = str.length(), maxToys = 0;
        while (j < n) {
            Integer charCount = charCountMap.getOrDefault(str.charAt(j), 0);
            charCountMap.put(str.charAt(j), charCount + 1);

            if (charCountMap.size() == k) {
                int count = 0;
                for (int val : charCountMap.values()) {
                    count += val;
                }
                maxToys = Math.max(maxToys, count);
            } else if (charCountMap.size() > k) {
                while (charCountMap.size() > k) {
                    char charAtI = str.charAt(i);
                    final Integer charAtICurrentCount = charCountMap.get(charAtI);
                    if (charAtICurrentCount > 1) {
                        charCountMap.put(charAtI, charAtICurrentCount - 1);
                    } else if (charAtICurrentCount == 1) {
                        charCountMap.remove(charAtI);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxToys;
    }


}

package binary_search;

/**
 * Given an array of letters sorted in ascending order, find the smallest letter in the the array which is greater than a given key letter. .
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 */
public class NextAlphabeticalElement {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'c', 'f', 'h'};
        char c = 'f';

        char nextAlphabet = nextAlphabet(charArray, c);
        System.out.println("nextAlphabet " + nextAlphabet);
    }

    private static char nextAlphabet(char[] charArray, char c) {
        int start = 0;
        int end = charArray.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            final char midChar = charArray[mid];

            if (midChar - c == 0)
                start = mid+1;
            else if (midChar > c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return charArray[start];
    }
}

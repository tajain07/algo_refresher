package recursion.input_output;

/**
 * Problem Description: https://leetcode.com/problems/letter-...
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String input = "a1b2";
        String output = "";

        letterCasePermutation(input, output);
    }

    private static void letterCasePermutation(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        final char characterAt0 = input.charAt(0);

        input = input.substring(1);

        final boolean isDigit = Character.isDigit(characterAt0);

        String output1 = output + characterAt0;

        if (isDigit) {
            letterCasePermutation(input, output1);

        } else {

            String output2;

            final boolean isUpperCase = Character.isUpperCase(characterAt0);

            if (isUpperCase) {
                output2 = output + Character.toLowerCase(characterAt0);
            } else {
                output2 = output + Character.toUpperCase(characterAt0);

            }
            letterCasePermutation(input, output1);

            letterCasePermutation(input, output2);

        }

    }
}

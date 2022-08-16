package recursion.input_output;

/**
 * https://practice.geeksforgeeks.org/problems/permutation-with-spaces/0
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.
 * Input:  str[] = "ABC"
 * Output: (A B C)(A BC)(AB C)(ABC)
 */
public class PermutationWithSpaces {
    public static void main(String[] args) {
        String input = "ABC";
        String output = "";
        //permutationWithSpaces(input, input);
        //permutationWithSpacesMethod2(input, output);
        permutationWithSpacesMethod3(input, output);

    }

    /**
     * This code - will copy 1st element from input to output and then will work same as print subset
     *
     * @param input
     * @param output
     */
    private static void permutationWithSpacesMethod3(String input, String output) {
        output = output + input.charAt(0);
        input = input.substring(1);

        permutationWithSpacesMethod3Runner(input, output);
    }

    private static void permutationWithSpacesMethod3Runner(String input, String output) {

        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String output1 = output + " " + input.charAt(0);
        String output2 = output + input.charAt(0);

        input = input.substring(1);

        permutationWithSpacesMethod3Runner(input, output1);
        permutationWithSpacesMethod3Runner(input, output2);
    }

    /**
     * Input - ABC
     * Ouput - ABC
     * <p>
     * This method will insert " " in output as per input's length
     *
     * @param input
     * @param output
     */
    private static void permutationWithSpacesMethod1(String input, String output) {

        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        int splitLength = output.length() - input.length();
        input = input.substring(1);

        if (splitLength != 0) {
            String output2 = output.substring(0, splitLength) + " " + output.substring(splitLength);
            permutationWithSpacesMethod1(input, output2);
        }

        permutationWithSpacesMethod1(input, output);

    }

    private static void permutationWithSpacesMethod2(String input, String output) {

        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        final char newChar = input.charAt(0);
        String newInput = input.substring(1);

        if (!output.isEmpty()) {
            String output2 = output + " " + newChar;
            permutationWithSpacesMethod2(newInput, output2);
        }

        output = output + newChar;

        permutationWithSpacesMethod2(newInput, output);

    }

    private static void permutationWithSpacesMethod4(String input, String ouput, int index) {
        if (input.length() == index) {
            System.out.println(ouput);
            return;
        }


        permutationWithSpacesMethod4(input, ouput + input.charAt(index), index + 1);

        if (index != 0) {
            permutationWithSpacesMethod4(input, ouput + ' ' + input.charAt(index), index + 1);
        }

    }
}

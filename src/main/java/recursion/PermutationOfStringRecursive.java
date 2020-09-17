package recursion;

/**
 * input - ABC
 * output - ABC, ACB, BAC, BCA, CAB, CBA
 *
 */
public class PermutationOfStringRecursive {
    public static void main(String[] args) {
        String input = "ABC";
        String output = "";

        permuatationOfStringRecursive(input, output);
    }

    private static void permuatationOfStringRecursive(String input, String output) {

        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            String newOutput = output + input.charAt(i);
            String newInput = input.substring(0, i) + input.substring(i + 1);

            permuatationOfStringRecursive(newInput, newOutput);
        }
    }
}

package recursion.input_output;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";

        permutationWithCaseChange(input, output);
    }

    private static void permutationWithCaseChange(String input, String ouput) {
        if (input.length() == 0) {
            System.out.println(ouput);
            return;
        }

        String output1 = ouput + input.charAt(0);
        String output2 = ouput + Character.toUpperCase(input.charAt(0));

        input = input.substring(1);

        permutationWithCaseChange(input, output1);
        permutationWithCaseChange(input, output2);
    }
}

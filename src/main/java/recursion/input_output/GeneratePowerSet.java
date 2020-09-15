package recursion.input_output;

/**
 * Print all subsets of a String.
 * https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
 *
 */
public class GeneratePowerSet {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";

        printPowerSets(input, output);
    }

    public static void printPowerSets(String input, String output) {

        if (input.length() == 0) {
            if (output.isEmpty()) {
                System.out.println("Empty");
            } else {
                System.out.println(output);
            }
            return;
        }

        String output1 = output;
        String output2 = output + input.charAt(0);

        input = input.substring(1);
        printPowerSets(input, output1);
        printPowerSets(input, output2);

    }
}

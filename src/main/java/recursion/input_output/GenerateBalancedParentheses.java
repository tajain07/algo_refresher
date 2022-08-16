package recursion.input_output;

/**
 * Problem Description: https://www.interviewbit.com/problems...
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * <p>
 * https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
 */
public class GenerateBalancedParentheses {
    public static void main(String[] args) {
        int n = 2;
        generateBalancedParentheses(n);
    }

    private static void generateBalancedParentheses(int n) {
        printBalancedParenthesesHelper(3, 3, "");
    }

    private static void printBalancedParenthesesHelper(int opening_count, int closing_count, String output) {

        if (opening_count == 0 && closing_count == 0) {
            System.out.println(output);
            return;
        }

        if (opening_count > 0) printBalancedParenthesesHelper(opening_count - 1, closing_count, output + "(");


        //We cannot have a closing bracket before opening bracket
        //)( --> illegal
        //() --> legal
        if (opening_count < closing_count) {
            printBalancedParenthesesHelper(opening_count, closing_count - 1, output + ")");
        }
    }
}

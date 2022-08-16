package recursion.input_output;

/**
 * https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
 *
 */
public class PrintNBitBinaryNumberHavingMoreOrEqual1than0 {
    public static void main(String[] args) {
        int n = 2;
        printNBitBinaryNumber(n);
    }

    private static void printNBitBinaryNumber(int n) {
        printNBitBinaryNumber(0, 0, n, "");
    }


    private static void printNBitBinaryNumber(int numOf1, int numOf0, int n, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }
        if (n > 0)
            printNBitBinaryNumber(numOf1 + 1, numOf0, n - 1, output + "1");

        if (numOf0 < numOf1) {
            printNBitBinaryNumber(numOf1, numOf0 + 1, n - 1, output + "0");
        }
    }
}

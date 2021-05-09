package backtracking;

/**
 * A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a
 * one-to-one correspondence with S itself. A string of length n has n! permutation.
 *
 * Source: Mathword(http://mathworld.wolfram.com/Permutation.html)
 *
 * Below are the permutations of string ABC.
 *
 * Input -  ABC
 * Output - ABC ACB BAC BCA CBA CAB
 *
 */

public class PermutationOfAStringUsingBacktracking {
    public static void main(String[] args) {
        String str = "abc";
        permute(str, 0, str.length() - 1);
    }

    private static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
            return;
        }
        for (int i = start; i <= end; i++) {
            //do
            str = swap(str, start, i);
            //recur
            permute(str, start + 1, end);
            //undo
            str = swap(str, start, i);
        }
    }

    private static String swap(String str, int start, int i) {
        char t;
        final char[] chars = str.toCharArray();
        t = chars[start];
        chars[start] = chars[i];
        chars[i] = t;
        return String.valueOf(chars);
    }
}

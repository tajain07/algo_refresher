package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * <p>
 * Given an unsorted array of size n. Array elements are in the range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the array.
 * Find these two numbers in order of one space.
 * <p>
 * Input:[3 1 2 5 3]
 * <p>
 * Output:[3, 4]
 * <p>
 * Duplicate = 3, Missing = 4
 */
public class FindMissingAndDuplicateNumber1ToN {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 3};
        final List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        final ArrayList<Integer> result = repeatedNumbers(list);
        System.out.println("Result " + result);

    }

    public static ArrayList<Integer> repeatedNumbers(final List<Integer> A) {
        ArrayList<Integer> out = new ArrayList<>();
        double l = A.size();
        double sum = (l * (l + 1)) / 2;
        long sumA = 0;
        int a = 0;
        Set<Integer> ASet = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (ASet.contains(A.get(i))) {
                a = A.get(i);
            }
            ASet.add(A.get(i));
            sumA = sumA + A.get(i);
        }
        double diff = sumA - sum;
        int b = a - (int) diff;
        out.add(a);
        out.add(b);
        return out;
    }
}

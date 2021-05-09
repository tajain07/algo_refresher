package sliding_window.variable_size_sliding_window;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    https://www.geeksforgeeks.org/longest-sub-array-sum-k/

    Given an array containing N positive integers and an integer K.
    Your task is to find the length of the longest Sub-Array with sum of
    the elements equal to the given value K.

    For Input:
    1
    7 5
    4 1 1 1 2 3 5
    your output is:
    4
 */
public class LongestSubarrayOfSumK {
    public static void main(String[] args) {

        int[] arr = new int[]{4, 1, 1, 1, 2, 3, 5};
        final List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int maxLength = largestSubArray(arrayList, 5);
        System.out.println("maxLength " + maxLength);

    }

    private static int largestSubArray(List<Integer> arrayList, int sum) {
        int i = 0, j = 0, maxWindow = 0, minWindow = arrayList.size(), runningSum = 0;

        while (j < arrayList.size()) {

            runningSum += arrayList.get(j);

            while (runningSum > sum) {
                runningSum -= arrayList.get(i++);

            }

            if (sum == runningSum) {
                maxWindow = Math.max(maxWindow, j - i + 1);
                minWindow = Math.min(minWindow, j - i + 1);

            }


            j++;
        }

        if (minWindow > maxWindow) {
            minWindow = 0;
        }
        System.out.println("minWindow " + minWindow);

        return maxWindow;
    }
}

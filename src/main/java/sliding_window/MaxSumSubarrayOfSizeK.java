package sliding_window;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int sum = maxSumBruteForce(new int[]{2, 5, 1, 8, 2, 9, 1}, 3);
        System.out.println("Max sum " + sum);
        assertEquals(sum, 19);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(1);
        sum = maxSumSlidingWindow(3, list, list.size());
        System.out.println("Max sum " + sum);
        assertEquals(sum, 19);

    }

    public static int maxSumBruteForce(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < k && j + i < arr.length; j++) {
                sum += arr[j + i];
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static int maxSumSlidingWindow(int K, ArrayList<Integer> Arr, int N) {
        int i = 0, j = 0;
        int maxSum = 0, runningSum = 0;

        while (j < Arr.size()) {
            runningSum = runningSum + Arr.get(j);
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                maxSum = Math.max(maxSum, runningSum);
                runningSum = runningSum - Arr.get(i);
                i++;
                j++;
            }

        }
        return maxSum;
    }
}

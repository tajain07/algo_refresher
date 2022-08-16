package leetcode_contest_302;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        //int[] nums = {18, 43, 36, 13, 7};
        //int[] nums = {18, 43, 36, 13, 7, 34, 52};
        int[] nums = {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        int sum = maximumSum(nums);
        System.out.println("sum " + sum);
    }

    public static int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> digitSumMap = new HashMap<>();
        for (int num : nums) {
            int sum = sumOfDigits(num);

            final PriorityQueue<Integer> orDefault = digitSumMap.getOrDefault(sum, new PriorityQueue<>((o1, o2) -> o2 - o1));
            orDefault.add(num);
            digitSumMap.put(sum, orDefault);
        }

        int maxSum = -1;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : digitSumMap.entrySet()) {

            int digitSum = entry.getKey();
            final PriorityQueue<Integer> value = entry.getValue();
            if (value.size() >= 2)
                maxSum = Math.max(maxSum, value.poll()+value.poll());
        }
        return maxSum;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}

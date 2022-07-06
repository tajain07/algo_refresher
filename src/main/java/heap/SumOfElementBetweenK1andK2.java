package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of integers and two numbers k1 and k2. Find the sum of all elements
 * between given two k1’th and k2’th smallest elements of the array. It may  be assumed
 * that all elements of array are distinct.
 * <p>
 * Example :
 * Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
 * Output : 26
 * 3rd smallest element is 10. 6th smallest element
 * is 20. Sum of all element between k1 & k2 is
 * 12 + 14 = 26
 */
public class SumOfElementBetweenK1andK2 {
    public static void main(String[] args) {
        Integer[] nums = {1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;
        int sum = sumOfElementsBetweenK1thAndk2thSmallestElement_approach1(nums, k1, k2);
        System.out.println("sumOfElementsBetweenK1thAndk2thSmallestElement_approach1, sum " + sum);
        sum = sumOfElementsBetweenK1thAndk2thSmallestElement_approach2(nums, k1, k2);
        System.out.println("sumOfElementsBetweenK1thAndk2thSmallestElement_approach2, sum " + sum);

    }

    private static int sumOfElementsBetweenK1thAndk2thSmallestElement_approach1(Integer[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        Collections.addAll(maxHeap, nums);

        int bigger = Math.max(k1, k2);
        int smaller = Math.min(k1, k2);

        while (maxHeap.size() >= bigger)
            maxHeap.poll();

        int sum = 0;
        while (maxHeap.size() > smaller) {
            sum += maxHeap.poll();
        }
        //System.out.println(maxHeap);

        return sum;
    }


    private static int sumOfElementsBetweenK1thAndk2thSmallestElement_approach2(Integer[] nums, int k1, int k2) {
        final int k1ThSmallestElement = KthSmallestElement.kSmallestUsingHeap(nums, k1);
        final int k2ThSmallestElement = KthSmallestElement.kSmallestUsingHeap(nums, k2);

        int sum = 0;
        int bigElement = Math.max(k1ThSmallestElement, k2ThSmallestElement);
        int smallElement = Math.min(k1ThSmallestElement, k2ThSmallestElement);

        for (int num : nums) {
            if (num > smallElement && num < bigElement)
                sum += num;
        }

        return sum;
    }
}


package heap;

import java.util.Arrays;

/**
 * https://youtu.be/4BfL2Hjvh8g
 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.
 * Example:
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 3
 * Output: 7
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        int a[] = { 20, 10, 4, 3, 7, 11, 15 };
        int k = 3;

        int kSmallestElement = kSmallestUsingSorting(a, k);
        System.out.println("k " + k + " smallest element : " + kSmallestElement);

        kSmallestElement = kSmallestUsingHeap(a, k);
        System.out.println("k " + k + " smallest element : " + kSmallestElement);

        kSmallestElement = kSmallestUsingHeapRemovingKElement(a, k);
        System.out.println("k " + k + " smallest element : " + kSmallestElement);
    }

    /**
     * @param a
     * @param k
     * @return
     */
    private static int kSmallestUsingHeap(int[] a, int k) {

        MaxHeap maxHeap = new MaxHeap(k + 1);

        for (int i = 0; i < a.length; i++) {
            maxHeap.insert(a[i]);

            if (maxHeap.getSize() > k) {
                maxHeap.extractMax();
            }
        }
        //maxHeap
        return maxHeap.extractMax();

    }

    /**
     * @param a
     * @param k
     * @return
     */
    private static int kSmallestUsingHeapRemovingKElement(int[] a, int k) {

        MaxHeap maxHeap = new MaxHeap(a);

        for (int i = 0; i < a.length - k; i++) {
            maxHeap.extractMax();
        }
        return maxHeap.extractMax();

    }

    //O(nLogn)
    private static int kSmallestUsingSorting(int[] a, int k) {
        //sort array
        Arrays.sort(a);
        return a[k - 1];
    }
}

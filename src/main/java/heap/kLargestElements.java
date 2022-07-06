package heap;

import java.util.Arrays;

public class kLargestElements {
    public static void main(String[] args) {
        Integer[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int[] kLargestElements = kLargestElements_Using_MaxHeap(arr, k);
        System.out.println(" kLargestElements " + Arrays.toString(kLargestElements));

        kLargestElements = kLargestElements_Using_MinHeap(arr, k);
        System.out.println(" kLargestElements " + Arrays.toString(kLargestElements));

    }

    private static int[] kLargestElements_Using_MinHeap(Integer[] arr, int k) {
        MinHeap minHeap = new MinHeap(k + 1);
        for (int i = 0; i < arr.length; i++) {
            minHeap.insert(arr[i]);
            if (minHeap.getSize() > k) {
                int min = minHeap.extractMin();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (minHeap.getSize() > 0) {
            result[i++] = minHeap.extractMin();
        }

        return result;
    }

    private static int[] kLargestElements_Using_MaxHeap(Integer[] arr, int k) {
        int[] answer = new int[k];
        MaxHeap maxHeap = new MaxHeap(arr);

        for (int i = 0; i < k; i++) {
            answer[i] = maxHeap.extractMax();
        }

        return answer;
    }
}

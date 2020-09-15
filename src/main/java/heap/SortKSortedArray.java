package heap;

import java.util.Arrays;

public class SortKSortedArray {
    public static void main(String[] args) {
        int a[] = { 7, 6, 9, 10, 4, 2, 3 };
        SortKSortedArray sortKSortedArray = new SortKSortedArray();
        int k = 3;
        final int[] ints = sortKSortedArray.sortKSortedArray(a, k);
        System.out.println(Arrays.toString(ints));
    }

    private int[] sortKSortedArray(int[] a, int k) {
        int[] sortedArray = new int[a.length];
        MaxHeap maxHeap = new MaxHeap(k + 1);

        int sortedArrayIndex = 0;

        for (final int element : a) {
            maxHeap.insert(element);
            if (maxHeap.getSize() > k) {
                final int maxElement = maxHeap.extractMax();
                sortedArray[sortedArrayIndex++] = maxElement;
            }
        }

        while (maxHeap.getSize() > 0) {
            sortedArray[sortedArrayIndex++] = maxHeap.extractMax();
        }

        return sortedArray;
    }
}

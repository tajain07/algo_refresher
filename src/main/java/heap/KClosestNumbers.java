package heap;


import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestNumbers {
    public static void main(String[] args) {
        int a[] = {5, 6, 7, 8, 9};
        //int a[] = {10, 2, 14, 4, 7, 6};

        int k = 3;
        int x = 7;
        int[] closestNumbers = kClosestNumbers(a, k, x);
        System.out.println("kClosestNumbers " + Arrays.toString(closestNumbers));

        closestNumbers = kClosestNumbers_old(a, k, x);
        System.out.println("kClosestNumbers_old " + Arrays.toString(closestNumbers));

    }

    private static int[] kClosestNumbers(int[] a, int k, int x) {
        int[] answer = new int[k];


        java.util.PriorityQueue<Pair<Integer, Integer>> maxHeap = new java.util.PriorityQueue<>(k + 1, (o1, o2) -> o2.getKey() - o1.getKey());

        for (int num : a) {
            int diff = Math.abs((num - x));
            maxHeap.add(new Pair<>(diff, num));
        }

        while (maxHeap.size() > k) {
            maxHeap.poll();
        }

        int i = 0;
        while (maxHeap.size() > 0) {
            answer[i++] = maxHeap.poll().getValue();
        }

        return answer;
    }

    private static int[] kClosestNumbers_old(int[] a, int k, int x) {

        int[] answer = new int[k];

        java.util.PriorityQueue<Pair<Integer, Integer>> maxHeap = new java.util.PriorityQueue<>(k + 1, (o1, o2) -> o2.getKey() - o1.getKey());

        for (int j : a) {
            final int element = Math.abs(j - x);

            maxHeap.add(new Pair<>(element, j));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int resultIndex = 0;
        while (maxHeap.size() > 0) {

            final Integer value = maxHeap.poll().getValue();

            answer[resultIndex++] = value;
        }
        return answer;
    }
}

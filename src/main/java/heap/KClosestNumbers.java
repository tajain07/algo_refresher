package heap;


import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestNumbers {
    /*public static void main(String[] args) {
        //int a[] = { 5, 6, 7, 8, 9 };
        int a[] = {10, 2, 14, 4, 7, 6};

        int k = 3;
        int x = 5;
        final int[] ints = kClosestNumbers(a, k, x);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] kClosestNumbers(int[] a, int k, int x) {

        int[] answer = new int[k];

        //TODO - convert MaxHeap to generic type so that can accept Pair/Array
        java.util.PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(k + 1, (o1, o2) -> o2.getKey() - o1.getKey());

        for (int i = 0; i < a.length; i++) {
            final int element = Math.abs(a[i] - x);

            maxHeap.add(new Pair<>(element, a[i]));
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
    }*/
}

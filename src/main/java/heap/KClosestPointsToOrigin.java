package heap;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] a = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int k = 2;
        final int[][] ints = kClosestPointsToOrigin.kClosestPointsToOrigin(a, k);
        for (int[] element : ints) {
            System.out.println(element[0] + " " + element[1]);
        }
    }

    private int[][] kClosestPointsToOrigin(int[][] a, int k) {

        int[][] answer = new int[k][2];

        PriorityQueue <Pair <Integer, Integer>> heap = new java.util.PriorityQueue <>(k + 1, (o1,o2)-> o2.getKey()-o1.getKey());

        for (int i = 0; i < a.length; i++) {
            final int[] points = a[i];
            final int distance = (int) (Math.pow(points[0], 2) + Math.pow(points[1], 2));
            heap.add(new Pair <>(distance, i));

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int index = 0;
        while (heap.size() > 0) {
            answer[index++] = a[heap.poll().getValue()];
        }

        return answer;
    }
}

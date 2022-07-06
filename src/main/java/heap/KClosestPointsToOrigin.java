package heap;


import javafx.util.Pair;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Integer[][] a = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        final Integer[][] ints = kClosestPointsToOrigin(a, k);
        for (Integer[] element : ints) {
            System.out.println("closest element " + element[0] + " " + element[1]);
        }
    }

    private static Integer[][] kClosestPointsToOrigin(Integer[][] nums, int k) {
        PriorityQueue<Pair<Integer, Integer[]>> maxHeap = new PriorityQueue<>(k + 1, (o1, o2) -> o2.getKey() - o1.getKey());

        for (Integer[] num : nums) {
            int x = num[0];
            int y = num[1];
            // int distance = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            // relative ordering will be same with and without square root so to save computation,
            // we can avoid square root
            int distance = (int) (Math.pow(x, 2) + Math.pow(y, 2));

            maxHeap.add(new Pair<>(distance, num));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        Integer[][] requiredTypeResponse = new Integer[k][2];
        int i = 0;
        while (maxHeap.size() > 0) {
            final Pair<Integer, Integer[]> entry = maxHeap.poll();
            final Integer[] value = entry.getValue();
            requiredTypeResponse[i++] = (value);
        }

        return requiredTypeResponse;
    }

    /*private int[][] kClosestPointsToOrigin(int[][] a, int k) {

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
    }*/
}

package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect
 * two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.
 * <p>
 * For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
 * 1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * <p>
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of
 * connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first
 * (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2).
 * Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 */
public class ConnectRopesToMinimiseTheCost {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        int minCost = minCost(a);
        System.out.println(minCost);
    }

    private static int minCost(Integer[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(a.length);
        Collections.addAll(minHeap, a);


        int totalCost = 0;
        while (minHeap.size() > 1) {
            final Integer rope1 = minHeap.poll();
            final Integer rope2 = minHeap.poll();
            int currentOPCost = rope1 + rope2;
            totalCost += currentOPCost;
            minHeap.add(currentOPCost);
        }


        return totalCost;
    }

}

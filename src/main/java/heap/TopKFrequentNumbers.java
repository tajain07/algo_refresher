package heap;


import javafx.util.Pair;

import java.util.*;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int[] a = {1, 1, 3, 2, 2, 2, 4, 4, 4};
        int k = 2;
        final int[] frequentNumbers = topKFrequentNumber(a, k);
        System.out.println("topKFrequentNumber  " + Arrays.toString(frequentNumbers));
    }

    private static int[] topKFrequentNumber(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(k + 1, Comparator.comparingInt(Pair::getKey));

        //Java 7
        for (int num : nums) {
            final Integer value = countMap.getOrDefault(num, 0);
            countMap.put(num, value + 1);
        }
        //Java 8
        //final Map <Integer, Long> countMap = Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        final Set<Integer> keys = countMap.keySet();
        for (Integer key : keys) {
            minHeap.add(new Pair<>(countMap.get(key), key));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (minHeap.size() > 0) {
            final Pair<Integer, Integer> pair = minHeap.poll();
            res[i++] = pair.getValue();
        }

        return res;
    }

}

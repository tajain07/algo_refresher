package heap;


import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {


    public static void main(String[] args) {
        Integer[] a = {1, 1, 1, 3, 2, 2, 4};
        final int[] ints = freqSort(a);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] freqSort(Integer[] nums) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(nums.length, (o1, o2) -> o2.getKey() - o1.getKey());

        final Map<Integer, Long> freqMap = Arrays.stream(nums).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
            maxHeap.add(new Pair<>(Math.toIntExact(entry.getValue()), entry.getKey()));
        }

        int[] response = new int[nums.length];
        int i = 0;
        while (maxHeap.size() > 0) {
            final Pair<Integer, Integer> pair = maxHeap.poll();
            final Integer freq = pair.getKey();
            final Integer num = pair.getValue();
            for (int k = 0; k < freq; k++) {
                response[i++] = num;
            }
        }
        return response;
    }

}

package heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {
    public static void main(String[] args) {
        Integer a[] = { 1, 1, 1, 3, 2, 2, 4 };
        final int[] ints = freqSort(a);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] freqSort(Integer[] a) {

        int[] answer = new int[a.length];

        final Map <Integer, Long> frequencyMap = Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        PriorityQueue <Pair <Integer, Long>> maxHeap = new PriorityQueue <Pair <Integer, Long>>(a.length, ((o1, o2) -> (int) (o2.getValue() - o1.getValue())));

        for (Map.Entry <Integer, Long> entry : frequencyMap.entrySet()) {
            maxHeap.add(new Pair <>(entry.getKey(), entry.getValue()));
        }

        int index = 0;
        while (maxHeap.size() > 0) {
            final Pair <Integer, Long> pair = maxHeap.poll();
            int frequency = Math.toIntExact(pair.getValue());
            for (int i = 0; i < frequency; i++) {
                answer[index++] = pair.getKey();
            }
        }

        return answer;
    }
}

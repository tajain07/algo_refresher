package heap;


import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {
    /*public static void main(String[] args) {
        Integer a[] = { 1, 3, 2, 2, 4, 4, 4 };
        int k = 2;
        final int[] ints = topKFrequentNumber(a, k);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] topKFrequentNumber(Integer[] a, int k) {

        int[] ans = new int[k];
        final Map <Integer, Long> countMap = Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue <Pair <Integer, Long>> minHeap = new PriorityQueue <>(k + 1, (o1, o2) -> (int) (o1.getValue() - o2.getValue()));

        for (Map.Entry <Integer, Long> entrySet : countMap.entrySet()) {
            minHeap.add(new Pair <>(entrySet.getKey(), entrySet.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int index = 0;
        while (minHeap.size() > 0) {
            ans[index++] = minHeap.poll().getKey();
        }

        return ans;
    }
*/
}

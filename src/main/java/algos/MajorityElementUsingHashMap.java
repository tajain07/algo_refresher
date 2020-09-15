package algos;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementUsingHashMap {
    public static void main(String[] args) {
        int[] a = {
                5, 7, 9, 5, 5, 2, 5, 5
        };

        int majorityElement = majorityElementJava7(a);
        System.out.println("element " + majorityElement);
    }

    public static int majorityElementJava7(int[] a) {
        if (a == null)
            return -1;

        Map <Integer, Integer> freqMap = new HashMap <Integer, Integer>();
        int majorityCount = a.length / 2 + 1;

        for (int element : a) {

            if (freqMap.containsKey(element)) {
                int count = freqMap.get(element) + 1;

                if (count >= majorityCount) {
                    return element;

                }
                freqMap.put(element, count);
            } else {
                freqMap.put(element, 1);
            }
        }

        return -1;

    }
}
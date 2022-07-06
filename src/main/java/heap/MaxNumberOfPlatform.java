package heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxNumberOfPlatform {
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 1200, 1201, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1201, 1201, 1900, 2000};

        int maxPlatformNew = getMaximumPlatform_BruteForce(arr, dep);
        System.out.println("getMaximumPlatform_BruteForce, maxPlatformNew  " + maxPlatformNew);

        maxPlatformNew = getMaximumPlatform_Using_Heap(arr, dep);
        System.out.println("getMaximumPlatform_Using_Heap, maxPlatformNew  " + maxPlatformNew);

        int maxPlatform = getMaximumPlatform_Using_LinkedList(arr, dep);
        System.out.println("getMaximumPlatform_Using_LinkedList, maxPlatform " + maxPlatform);

    }

    /**
     * Time Complexity: O(n^2)  (due to two nested loops).
     * Space Complexity: O(1)  (no extra space used).
     *
     */
    private static int getMaximumPlatform_BruteForce(int[] arr, int[] dep) {
        int maxPlatform = 0;
        for (int i = 0; i < arr.length; i++) {
            int platform = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i] && arr[j] < dep[i] || arr[i] > arr[j] && arr[i] < dep[j]) {
                    platform++;
                }
            }
            maxPlatform = Math.max(platform, maxPlatform);
        }
        return maxPlatform;
    }

    // Time Complexity: O(N*log(N))
    //Auxiliary Space: O(N)
    static int getMaximumPlatform_Using_Heap(int[] arrivalTimings, int[] departureTimings) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int maxPlatform = 0;

        for (int i = 0; i < arrivalTimings.length; i++) {
            int currentArrivalTime = arrivalTimings[i];
            int currentDepartureTime = departureTimings[i];
            while (heap.size() > 0 && heap.peek() <= currentArrivalTime) {
                heap.poll();
            }
            heap.add(currentDepartureTime);
            maxPlatform = Math.max(heap.size(), maxPlatform);
        }

        return maxPlatform;
    }

    static int getMaximumPlatform_Using_LinkedList(int[] arr, int[] dep) {
        Queue<Integer> pendingDepartureTime = new LinkedList<>();
        int maxPlatform = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            final int currentArrivalTime = arr[i];
            final int currentDeptTime = dep[i];

            pendingDepartureTime.removeIf(deptTime -> deptTime < currentArrivalTime);

            pendingDepartureTime.add(currentDeptTime);
            maxPlatform = Math.max(maxPlatform, pendingDepartureTime.size());

        }
        return maxPlatform;


    }

}

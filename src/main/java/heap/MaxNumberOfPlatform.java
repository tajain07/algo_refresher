package heap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxNumberOfPlatform {
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 1200, 1201, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1201, 1201, 1900, 2000};
        int maxPlatform = getMaximumPlatform(arr, dep);
        System.out.println("getMaximumPlatform maxPlatform " + maxPlatform);
        maxPlatform = getMaxiumPlatformUsingPriorityQueue(arr, dep);
        System.out.println("getMaxiumPlatformUsingPriorityQueue maxPlatform " + maxPlatform);
    }

    private static int getMaximumPlatform(int[] arr, int[] dep) {
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

    private static int getMaxiumPlatformUsingPriorityQueue(int[] arr, int[] dep) {
        PriorityQueue<Integer> pendingDepartureTime = new PriorityQueue<>();
        int maxPlatform = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            final int currentArrivalTime = arr[i];
            final int currentDeptTime = dep[i];

            while (pendingDepartureTime.peek() != null && pendingDepartureTime.peek() < currentArrivalTime) {
                pendingDepartureTime.poll();
            }


            pendingDepartureTime.add(currentDeptTime);
            maxPlatform = Math.max(maxPlatform, pendingDepartureTime.size());

        }
        return maxPlatform;


    }
}

package sliding_window;

import java.util.*;
import java.util.stream.Collectors;

/*
    https://www.interviewbit.com/problems/sliding-window-maximum/

    Given an array arr[] of size N and an integer K.
    Find the maximum for each and every contiguous
    subarray of size K.

    Example:

    Input 1:
        A = [1, 3, -1, -3, 5, 3, 6, 7]
        B = 3
    Output 1:
        C = [3, 3, 5, 5, 6, 7]

 */
public class MaximumOfAllSubArrays {
    public static void main(String[] args) {
        //int[] inputArr = new int[]{542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
        int[] inputArr = new int[]{4, -1, 3, 2, 4, 3, 6, 7};

        final List<Integer> arr = Arrays.stream(inputArr).boxed().collect(Collectors.toList());

        int k = 3;

        final ArrayList<Integer> result = slidingMaximum(arr, k);
        System.out.println(result);


        final List<Integer> result1 = maxFromEachSubArray(inputArr, k);
        System.out.println(result1);


    }


    //Both methods are using same approach, it's just they are written little different [two way to write same code]
    private static List<Integer> maxFromEachSubArray(final int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();
        Queue<Integer> maxNumsQueue = new LinkedList<>();

        while (j < n) {
            int newNum = arr[j];
            while (!maxNumsQueue.isEmpty() && maxNumsQueue.peek() < newNum) {
                maxNumsQueue.poll();
            }
            maxNumsQueue.offer(newNum);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                result.add(maxNumsQueue.peek());
                int numToBeOutOfWindow = arr[i];
                if (maxNumsQueue.peek() != null && maxNumsQueue.peek() == numToBeOutOfWindow)
                    maxNumsQueue.poll();

                i++;
                j++;
            }


        }

        return result;
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0, j = 0;
        while (j < A.size()) {
            int elementAtJ = A.get(j);

            while (queue.size() > 0 && queue.getLast() < elementAtJ) {
                queue.removeLast();
            }
            queue.addLast(elementAtJ);
            if (j - i + 1 == B) {
                result.add(queue.getFirst());
                int elementAtI = A.get(i);
                if (queue.getFirst() == elementAtI) {
                    queue.removeFirst();
                }
                i++;

            }
            j++;
        }
        return result;
    }
}

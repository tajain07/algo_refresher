package sliding_window;

import java.util.*;
import java.util.stream.Collectors;

/*
    https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbi1IcWVBdV9vMjZNbEt6enFXVE9UQ01iVU1aZ3xBQ3Jtc0tuNHBwektsa1Q4NDdWTVZxUlRISWtIZ2NLNWd5blZaUVd6QWpRb1JhVTBWRV9YZllBT0psMU5JR1dJUmhWdFN4RXNYVDRxNHBJbTNKc1h2NXBaTUM0QjdocFFDVTNsR3NGWW1QRXoyVzNFRVBVSVdrVQ&q=https%3A%2F%2Fwww.interviewbit.com%2Fproblems%2Fsliding-window-maximum%2F%23

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
        int[] inputArr = new int[]{542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};

        final List<Integer> arr = Arrays.stream(inputArr).boxed().collect(Collectors.toList());

        int k = 9;

        final ArrayList<Integer> result = slidingMaximum(arr, k);
        System.out.println(result);

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

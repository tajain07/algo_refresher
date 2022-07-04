package two_pointer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 */
public class MaximumContinuousSeriesOf1s {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 1, 0, 1, 1, 0, 0, 1, 1, 1);
        int k = 1;
        List<Integer> count = maxContSeries(arr, k);
        System.out.println(count);
    }

    private static List<Integer> maxContSeries(List<Integer> arr, int k) {
        List<Integer> maxAnswer = new ArrayList<>();
        int[] maxPair = new int[2];
        int startPointer = 0, endPointer = -1;
        for (int i = 0; i < arr.size(); i++) {
            final int value = arr.get(i);
            if (value == 1)
                endPointer = i;
            else {
                if (k > 0) {
                    endPointer = i;
                    k--;
                } else {
                    while (arr.get(startPointer) != 0) {
                        startPointer = startPointer + 1;
                    }
                    startPointer++;
                    endPointer = i;

                }
            }

            if (endPointer - startPointer > maxPair[1] - maxPair[0]) {
                maxPair[1] = endPointer;
                maxPair[0] = startPointer;
            }
        }


        for (int i = maxPair[0]; i <= maxPair[1]; i++) {
            maxAnswer.add(i);
        }
        return maxAnswer;
    }
}

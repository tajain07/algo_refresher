package sliding_window;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 *
 */
public class MaximumContinuousSeriesOf1s {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 0, 0, 0, 0, 0, 1, 0, 1, 1 );
        int k = 2;
        List<Integer> count = maxContSeries(arr, k);
        System.out.println(count);
    }

    private static List<Integer> maxContSeries(List<Integer> arr, int k) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> maxAnswer = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
            final int value = arr.get(j);
            if (value == 1) {
                answer.add(j);
            } else if (value == 0) {
                if (k == 0) {
                    final ListIterator<Integer> integerListIterator = answer.listIterator();
                    while (integerListIterator.hasNext()) {
                        final int collectedIndexValue = integerListIterator.next();
                        integerListIterator.remove();

                        if (arr.get(collectedIndexValue) == 0) {
                            k++;
                            break;
                        }

                    }
                }
                if (k > 0) {
                    answer.add(j);
                    k--;
                }

            }
            if (answer.size() > maxAnswer.size()) {
                maxAnswer.clear();
                maxAnswer.addAll(answer);
            }
        }
        return maxAnswer;
    }
}

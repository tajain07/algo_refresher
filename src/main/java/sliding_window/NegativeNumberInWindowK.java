package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0#

/*

        Input:
        2
        5
        -8 2 3 -6 10
        2
        8
        12 -1 -7 8 -15 30 16 28
        3

        Output:
        -8 0 -6 -6
        -1 -1 -7 -15 -15 0

 */
public class NegativeNumberInWindowK {
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(12);
        Arr.add(-1);
        Arr.add(-7);
        Arr.add(8);
        Arr.add(-15);
        Arr.add(30);
        Arr.add(16);
        Arr.add(28);
        Arr.add(28);

        ArrayList<Integer> result = firstNegativeBruteForce(Arr, 3);
        System.out.println(result);

        result = firstNegativeSlidingWindow(Arr, 3);
        System.out.println(result);


    }

    private static ArrayList<Integer> firstNegativeSlidingWindow(ArrayList<Integer> arr, int windowSize) {
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> runningNumbers = new ArrayList<>();

        int j = 0, i = 0;
        while (j < n) {
            if (arr.get(j) < 0) runningNumbers.add(arr.get(j));

            if (j - i + 1 < windowSize) {
                j++;
            } else if (j - i + 1 == windowSize) {
                if (runningNumbers.size() == 0)
                    result.add(0);
                else {
                    result.add(runningNumbers.get(0));
                    final Integer windowStartNumber = arr.get(i);
                    if (runningNumbers.get(0).equals(windowStartNumber))
                        runningNumbers.remove(0);
                }
                j++;
                i++;
            }

        }
        return result;
    }

    private static ArrayList<Integer> firstNegativeBruteForce(ArrayList<Integer> arr, int windowSize) {
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>(arr.size() - windowSize + 1);

        for (int i = 0; i < arr.size(); i++) {
            int j = 0;
            while (j < windowSize && i + j < n) {
                if (arr.get(i + j) < 0) {
                    result.add(arr.get(i + j));
                    break;
                }
                //System.out.println(arr.get(i+j));
                j++;
            }

            //not able to find negative number in the window
            if (j == windowSize)
                result.add(0);

        }
        return result;
    }


}

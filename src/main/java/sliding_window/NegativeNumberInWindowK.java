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
        System.out.println(result.toString());

        result = firstNegativeSlidingWindow(Arr, 3);
        System.out.println(result.toString());


    }

    private static ArrayList<Integer> firstNegativeSlidingWindow(ArrayList<Integer> arr, int K) {
        int i = 0, j = 0;
        ArrayList<Integer> runningArray = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (j < arr.size()) {
            if (arr.get(j) < 0) {
                runningArray.add(arr.get(j));
            }
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (runningArray.size() == 0)
                    result.add(0);
                else {
                    result.add(runningArray.get(0));
                    int iNum = arr.get(i);
                    if (iNum == runningArray.get(0)) {
                        runningArray.remove(0);
                    }
                }
                i++;
                j++;
            }
        }

        return result;
    }

    private static ArrayList<Integer> firstNegativeBruteForce(ArrayList<Integer> arr, int K) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int j = 0;
            while (j < K && i + j < arr.size()) {
                if (arr.get(i + j) < 0) {
                    result.add(arr.get(i + j));
                    break;
                }
                j++;
            }

            //We have exhausted our window but not found any negative integer so add 0 as per question
            if (j == K) {
                result.add(0);
            }
        }
        return result;
    }
}

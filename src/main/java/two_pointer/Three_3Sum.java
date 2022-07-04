package two_pointer;

import java.sql.Array;
import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Three_3Sum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] arr = new int[]{-2, 0, 0, 2, 2};

        Set<Integer[]> pairs = threeSum_BruteForce(arr);

        for (Integer[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        List<List<Integer>> newPairs = threeSum_2Pointer(arr);
        for (List<Integer> pair : newPairs) {
            System.out.println(pair);
        }
    }

    private static List<List<Integer>> threeSum_2Pointer(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println("Sorted Array " + Arrays.toString(arr));
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int L = i + 1, R = n - 1;
            while (L < R) {
                int curSum = arr[i] + arr[L] + arr[R];
                if (curSum > 0) {
                    R--;
                } else if (arr[i] + arr[L] + arr[R] < 0) {
                    L++;
                } else {
                    List<Integer> sub = new LinkedList<>();
                    sub.add(arr[i]);
                    sub.add(arr[L]);
                    sub.add(arr[R]);
                    result.add(sub);
                    L++;
                    R--;

                    while (L < R && arr[L] == arr[L - 1])
                        L++;
                    while (L < R && arr[R] == arr[R + 1])
                        R--;

                }
            }
        }
        return new ArrayList<>(result);

    }

    /**
     * TC = O(n^3 logM)
     * SC = O(M)
     *
     * @param arr
     * @return
     */
    private static Set<Integer[]> threeSum_BruteForce(int[] arr) {
        Set<Integer[]> triplets = new TreeSet<>(Arrays::compare);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        triplets.add(new Integer[]{
                                arr[i], arr[j], arr[k]
                        });
                    }
                }
            }
        }

        return triplets;
    }
}

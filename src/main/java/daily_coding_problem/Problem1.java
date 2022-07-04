package daily_coding_problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 3, 7};
        int k = 17;
        boolean solution = canWeAddNumbersToK(arr, k);
        System.out.printf("solution %b \n", solution);
    }

    private static boolean canWeAddNumbersToK(int[] arr, int k) {

        Set<Integer> map = new HashSet<>();
        for (int num : arr) {
            if (map.contains(k - num))
                return true;
            else if (num < k) {
                map.add(num);
            }
        }
        return false;
    }
}

package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_New {
    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> result = threeSum(arr);
        System.out.println("result " + result);
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        if (n < 3)
            return res;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int L = i + 1, H = n - 1;

            if (i != 0 && arr[i] == arr[i - 1])
                continue;


            while (L < H) {
                int sum = arr[i] + arr[L] + arr[H];

                if (sum == 0) {
                    List<Integer> subRes = new ArrayList<>(3);
                    subRes.add(arr[i]);
                    subRes.add(arr[L]);
                    subRes.add(arr[H]);
                    res.add(subRes);
                    L++;
                    H--;

                    while (L < H && arr[L] == arr[L - 1])
                        L++;

                    while (L < H && arr[H] == arr[H + 1])
                        H--;

                } else if (sum > 0) {
                    H--;
                } else {
                    L++;
                }
            }
        }

        return res;
    }
}
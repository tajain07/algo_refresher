package leetcode_contest_302;

import java.sql.Array;
import java.util.*;

public class MinimuDeletionsToMakeArrayDivisible {
    public static void main(String[] args) {
        int[] nums = {3,2,6,2,35,5,35,2,5,8,7,3,4};
        int[] numsDivide = {105,70,70,175,105,105,105};

        System.out.println(minOperations(nums, numsDivide));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        int deletion = 0;
        List<Integer> numsUnique = new ArrayList<>();
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (int num : nums) {
            final Integer value = numberCount.getOrDefault(num, 0);
            if (value == 0) {
                numsUnique.add(num);
            }
            numberCount.put(num, value + 1);
        }
        Collections.sort(numsUnique);


        for (int i = 0; i < numsUnique.size(); i++) {
            final Integer element = numsUnique.get(i);
            int divisonCount = 0;
            for (int numDivide : numsDivide) {

                if (element > numDivide)
                    return -1;

                if (numDivide % element != 0) {
                    deletion = deletion + numberCount.get(element);
                    break;
                } else {
                    divisonCount++;
                }

                if (divisonCount == numsDivide.length)
                    return deletion;
            }
        }


        return -1;
    }
}

package bitwise;

public class ElementThatAppearsOnce {
    public static void main(String[] args) {
        int[] nums = {12, 1, 12, 3, 12, 1, 1, 8, 3, 3};
        int foundNumber = elementThatAppearsOnce(nums);
        System.out.println("foundNumber " + foundNumber);
    }

    private static int elementThatAppearsOnce(int[] nums) {
        int INT_SIZE = Integer.SIZE;
        int result = 0;
        int sum;

        for (int i = 0; i < INT_SIZE; i++) {
            sum = 0;
            int x = (1 << i);
            for (int num : nums) {
                if ((num & x) != 0) {
                    sum++;
                }
            }

            if ((sum % 3) != 0)
                result |= x;
        }
        return result;
    }
}

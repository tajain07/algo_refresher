package binary_search;

public class CheckOkFunction {
    public static void main(String[] args) {
        System.out.println(ok(new int[]{1,2,5,9}, 1, 6));
        System.out.println(ok(new int[]{1,2,5,9}, 4, 6));
        System.out.println(ok(new int[]{1,2,5,9}, 5, 6));
    }

    private static boolean ok(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            int qu = num / divisor;
            if( qu > 0){
                int remainder = num % 2;
                sum += Math.ceil(remainder);
            }

        }

        return sum < threshold;

    }

}

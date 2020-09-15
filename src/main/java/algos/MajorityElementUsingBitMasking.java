package algos;

class MajorityElementUsingBitMasking {
    public static void main(String[] args) {
        int[] a = { 4, 2, 3, 4, 3, 4, 4 };
        int mElement = majorityElement(a);
        System.out.println("majorityElement " + mElement);
    }

    public static int majorityElement(int[] nums) {

        int majorityElement = findCandidate(nums);
        //System.out.println("majorityElement " + majorityElement);
        boolean isMajorityElement = verifyMajorityElement(nums, majorityElement);

        return (isMajorityElement) ? majorityElement : -1;
    }

    private static int findCandidate(int[] nums) {
        int len = 32;
        int number = 0;

        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0)
                    count++;
            }

            if (count > (nums.length / 2)) {
                number += (1 << i);
            }
        }

        return number;
    }

    private static boolean verifyMajorityElement(int[] nums, int majorityElement) {

        int count = 0;
        int majority = (nums.length >> 1) + 1;

        for (int element : nums) {

            if (element == majorityElement)
                count++;

            if (count >= majority)
                return true;
        }

        return false;
    }
}
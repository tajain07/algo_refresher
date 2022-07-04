package binary_search;

import java.util.Arrays;

public class CapacityToShipPackageWithinDDays_LC1011 {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));

        System.out.println(shipWithinDays2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(shipWithinDays2(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    //Approach 1 - Moved helper function inside inside just to avoid confusion with other apporach
    public static int shipWithinDays(int[] weights, int days) {

        class Helper {
            private boolean feasible(int[] weights, int D, int capacity) {

                int days = 1;
                int total = 0;
                for (int weight : weights) {
                    total += weight;
                    if (total > capacity) {
                        total = weight;
                        days += 1;
                        if (days > D)
                            return false;
                    }
                }

                return true;
            }
        }

        Helper helper = new Helper();
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (helper.feasible(weights, days, mid))
                right = mid; //mid can be the answer as we are looking for something minimum
            else
                left = mid + 1;  //mid+1 because left can never be the answer if we cannot ship with mid then move to mid+1
        }
        return left;
    }

    //Approach 2
    public static int shipWithinDays2(int[] weights, int days) {

        int min = Arrays.stream(weights).max().getAsInt();

        int max = Arrays.stream(weights).sum();

        int retVal = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int daysRequired = numberOfDaysNeededWithCapacity(weights, mid);
            if (daysRequired > days) {
                min = mid + 1;
            } else {
                retVal = mid;
                max = mid - 1;
            }
        }
        return retVal;
    }

    private static int numberOfDaysNeededWithCapacity(int[] weights, int capacity) {
        int daysRequired = 1;
        int current = 0;

        for (int weight : weights) {
            current += weight;
            if (current > capacity) {
                daysRequired++;
                current = weight;
            }
        }

        return daysRequired;
    }
}

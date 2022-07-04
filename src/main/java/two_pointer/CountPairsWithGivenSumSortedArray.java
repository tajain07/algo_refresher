package two_pointer;

/**
 * https://youtu.be/ijKmiFqjzi4
 *
 */
public class CountPairsWithGivenSumSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 4, 5, 5, 5, 6, 6, 11};
        int count = numOfPairs(arr, 8);
        System.out.println("count " + count);
    }

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }


    private static int numOfPairs(int[] arr, int k) {
        int x = 0;
        int y = arr.length - 1;
        int count = 0;
        while (x < y) {
            if (arr[x] + arr[y] < k)
                x++;
            else if (arr[x] + arr[y] > k) {
                y--;
            } else if (arr[x] != arr[y]) {
                int c1 = 0;
                int c2 = 0;
                int xVal = arr[x];
                int yVal = arr[y];
                while (arr[x] == xVal) {
                    x++;
                    c1++;
                }
                while (arr[y] == yVal) {
                    y--;
                    c2++;
                }
                count += c1 * c2;

            } else {
                int c1 = y - x + 1;
                count += factorial(c1) / factorial(2) * factorial(c1 - 2);
                 x= y;
            }
        }
        return count;
    }
}

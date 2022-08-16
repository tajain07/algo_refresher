package divideandconquer;


/**
 * Time Complexity:
 * The worst case time complexity of the above solution is still O(n2). In the worst case, the randomized function may always pick a corner element. The expected time complexity of above randomized QuickSelect is O(n), see CLRS book or MIT video lecture for proof. The assumption in the analysis is, random number generator is equally likely to generate any number in the input range.
 * <p>
 * Space complexity:
 * O(1) since using constant variables
 */
public class kthSmallestElement_QuickSelect {
    public static void main(String[] args) {
        int[] arr = new int[]{17, 25, -45, 35, 51, -18, 33, 41, 19, 10, 40, 25, 44, 55, 25};
        for (int k = 0; k < 25; k++) {
            int kthSmallestElement = kthSmallestElement(arr, k);
            System.out.println("kthSmallestElement k = " + k + " " + kthSmallestElement);

        }
    }

    private static int kthSmallestElement(int[] arr, int k) {
        return kthSmallestElement(arr, 0, arr.length - 1, k);
    }

    private static int kthSmallestElement(int[] arr, int l, int h, int k) {
        //System.out.println("k " + k);
        if (k > 0 && k <= h - l + 1) {

            if (l == h)
                return arr[l];
            //int pivot = h;
            //int n = h - l + 1;
            int pivot = (int) (l + (Math.random() * (h - l + 1)));
            swap(arr, pivot, h);
            //System.out.println("pivot " + pivot);
            int partitionIndex = partition(arr, l, h, h);
            if (partitionIndex - l == k - 1)
                return arr[partitionIndex];
            else if (partitionIndex - l > k - 1) {
                return kthSmallestElement(arr, l, partitionIndex - 1, k);
            } else {
                return kthSmallestElement(arr, partitionIndex + 1, h, k - partitionIndex + l - 1);
            }
        }
        return Integer.MAX_VALUE;

    }

    private static int partition(int[] arr, int l, int h, int pivot) {

        int x = arr[h], i = l;
        for (int j = l; j < h; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, h);
        return i;

    }

    private static void swap(int[] arr, int k, int i) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}

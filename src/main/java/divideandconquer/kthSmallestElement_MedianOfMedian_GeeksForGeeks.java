package divideandconquer;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
 * <p>
 * Time Complexity:
 * The worst-case time complexity of the above algorithm is O(n). Let us analyze all steps.
 * Steps (1) and (2) take O(n) time as finding median of an array of size 5 takes O(1) time and there are n/5 arrays of size 5.
 * Step (3) takes T(n/5) time. Step (4) is a standard partition and takes O(n) time.
 * The interesting steps are 6) and 7). At most, one of them is executed. These are recursive steps. What is the worst-case size of these recursive calls? The answer is the maximum number of elements greater than medOfMed (obtained in step 3) or the maximum number of elements smaller than medOfMed.
 * How many elements are greater than medOfMed and how many are smaller?
 * At least half of the medians found in step 2 are greater than or equal to medOfMed. Thus, at least half of the n/5 groups contribute 3 elements that are greater than medOfMed, except for the one group that has fewer than 5 elements. Therefore, the number of elements greater than medOfMed is at least.
 * 3\left (\left \lceil \frac{1}{2}\left \lceil \frac{n}{5} \right \rceil \right \rceil-2 \right )\geq \frac{3n}{10}-6
 * Similarly, the number of elements which are less than medOfMed is at least 3n/10 – 6. In the worst case, the function recurs for at most n – (3n/10 – 6) which is 7n/10 + 6 elements.
 * Note that 7n/10 + 6 < 20 and that any input of 80 or fewer elements requires O(1) time. We can therefore obtain the recurrence
 * T(n)\leq \begin{cases} \Theta (1) & \text{ if } n\leq 80 \\ T(\left \lceil \frac{n}{5} \right \rceil)+T(\frac{7n}{10}+6)+O(n) & \text{ if } n> 90 \end{cases}
 * We show that the running time is linear by substitution. Assume that T(n) cn for some constant c and all n > 80. Substituting this inductive hypothesis into the right-hand side of the recurrence yields
 * <p>
 * T(n)  <= cn/5 + c(7n/10 + 6) + O(n)
 * <= cn/5 + c + 7cn/10 + 6c + O(n)
 * <= 9cn/10 + 7c + O(n)
 * <= cn,
 * since we can pick c large enough so that c(n/10 – 7) is larger than the function described by the O(n) term for all n > 80. The worst-case running time of is therefore linear (Source: http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap10.htm ).
 * Note that the above algorithm is linear in the worst case, but the constants are very high for this algorithm. Therefore, this algorithm doesn’t work well in practical situations; randomized quickSelect works much better and is preferred.
 */
public class kthSmallestElement_MedianOfMedian_GeeksForGeeks {
    public static void main(String[] args) {
        int[] arr = new int[]{17, 25, -45, 35, 51, -18, 33, 41, 19, 10, 40, 25};
        int n = arr.length, k = 7;
        System.out.println("K'th smallest element is "
                + kthSmallest(arr, 0, n - 1, k));
    }

    private static int kthSmallest(int[] arr, int l, int r, int k) {
        // If k is smaller than
        // number of elements in array
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1; // Number of elements in arr[l..r]

            // Divide arr[] in groups of size 5,
            // calculate median of every group
            //  and store it in median[] array.
            int i;

            // There will be floor((n+4)/5) groups;
            int[] median = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(arr, l + i * 5, l + i * 5 + 5);

            // For last group with less than 5 elements
            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, l + i * 5 + n % 5);
                i++;
            }

            // Find median of all medians using recursive call.
            // If median[] has only one element, then no need
            // of recursive call
            int medOfMed = (i == 1) ? median[i - 1] :
                    kthSmallest(median, 0, i - 1, i / 2);

            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int pos = partition(arr, l, r, medOfMed);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1) // If position is more, recur for left
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private static int partition(int[] arr, int l, int r, int x) {
        // Search for x in arr[l..r] and move it to end
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x)
                break;
        swap(arr, i, r);

        // Standard partition algorithm
        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static int findMedian(int[] arr, int i, int n) {
        Arrays.sort(arr, i, n);
        return arr[i + (n - i) / 2];                    // sort the array and return middle element

    }

}

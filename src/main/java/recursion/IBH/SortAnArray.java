package recursion.IBH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAnArray {

    public static final InsertInSortedArray sortedArray = new InsertInSortedArray();

    public static void main(String[] args) {
        List <Integer> list = new ArrayList <Integer>(Arrays.asList(61, 60, 59, -15, 115, 58, 57));

        sortRecusiveAndRecursiveInsertion(list, list.size() - 1);
        System.out.println(list);


        int a[] = {61, 60, 59, -15, 115, 58, 57 };
        sortRecusiveAndIterativeInsertion(a, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    /**
     *
     * @param a
     * @param n
     */
    private static void sortRecusiveAndRecursiveInsertion(List <Integer> a, int n) {
        if (n == 0)
            return;

        int temp = a.remove(n);
        sortRecusiveAndRecursiveInsertion(a, n - 1);

        sortedArray.insert(a, temp);
    }

    /**
     *
     * @param a
     * @param n
     */
    private static void sortRecusiveAndIterativeInsertion(int[] a, int n) {
        if (n == 0)
            return;

        int temp = a[n];
        sortRecusiveAndIterativeInsertion(a, n - 1);

        for (int i = 0; i < n; i++) {
            if (a[i] > temp) {
                //insert in between
                insertAt(a, n, i, temp);
                break;
            }

        }

    }

    private static void insertAt(int[] a, int n, int insertAtIndex, int element) {
        int j = n;
        for (; j > insertAtIndex; j--) {
            a[j] = a[j - 1];
        }
        a[j] = element;

    }

}

package recursion.IBH;

import java.util.Arrays;
import java.util.List;

public class SortAnArray {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(61, 60, 59, -15, 115, 58, 57);

        sortRecursiveAndRecursiveInsertion(list, list.size() - 1);
        System.out.println(list);


        int a[] = {61, 60, 59, -15, 115, 58, 57};
        sortRecursiveAndIterativeInsertion(a, a.length - 1);
        System.out.println(Arrays.toString(a));

    }


    private static void sortRecursiveAndRecursiveInsertion(List<Integer> a, int n) {

        //Single element is always sorted -- hence base condition
        if (n == 0)
            return;

        int temp = a.remove(n);
        sortRecursiveAndRecursiveInsertion(a, n - 1);

        InsertInSortedArray.insertElement(a, temp);
    }


    private static void sortRecursiveAndIterativeInsertion(int[] a, int n) {
        //Single element is always sorted -- hence base condition
        if (n == 0)
            return;

        int temp = a[n];
        sortRecursiveAndIterativeInsertion(a, n - 1);

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

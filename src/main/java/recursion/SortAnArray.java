package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortAnArray {
    public static void main(String[] args) {
        Integer[] elements = {2, 0, 11, 3, 9, 1, 16};
        List<Integer> a = new LinkedList<>(Arrays.asList(elements));
        sort(a);
        System.out.println(a);
    }

    private static void sort(List<Integer> a) {

        if (a.size() == 1)
            return;

        int lastElement = a.remove(a.size() - 1);
        sort(a);

        insertElement(a, lastElement);
    }

    private static void insertElement(List<Integer> a, int lastElement) {

        for (int i = 0; i < a.size(); i++) {
            Integer element = a.get(i);
            if (element >= lastElement) {
                a.add(i, lastElement);
                return;
            }
        }

        a.add(a.size() - 1, lastElement);
    }
}

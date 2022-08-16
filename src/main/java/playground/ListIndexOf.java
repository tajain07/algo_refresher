package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIndexOf {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{0, 2, 3};
        Integer[] arr2 = new Integer[]{1, 2, 3};
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);

        int minDistance = Integer.MAX_VALUE;
        int foundElement = -1;
        for (int element : list1) {
            int index = list2.indexOf(element);
            if (index != -1 && index < minDistance) {
                minDistance = index;
                foundElement = element;
            }
        }
    }
}

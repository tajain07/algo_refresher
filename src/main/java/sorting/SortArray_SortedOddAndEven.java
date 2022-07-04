package sorting;

import java.util.Arrays;

/**
 * Merge sort
 */
public class SortArray_SortedOddAndEven {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 2, 4, 15, 10, 19};
        arr = sort(arr);
        System.out.println("Sort array " + Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        int[] oddElements = Arrays.stream(arr).filter(e -> e % 2 != 0).toArray();
        int[] evenElements = Arrays.stream(arr).filter(e -> e % 2 == 0).toArray();

        System.out.println(Arrays.toString(oddElements));
        System.out.println(Arrays.toString(evenElements));
        return mergeArrays(evenElements, oddElements);
    }

    private static int[] mergeArrays(int[] evenElements, int[] oddElements) {
        int[] newArray = new int[evenElements.length + oddElements.length];
        int i = 0;
        int j = 0;
        int z = 0;

        while (i < evenElements.length && j < oddElements.length) {
            if (evenElements[i] < oddElements[j]) {
                newArray[z++] = evenElements[i++];
            } else {
                newArray[z++] = oddElements[j++];

            }
        }

        while (i < evenElements.length) {
            newArray[z++] = evenElements[i++];

        }
        while (j < oddElements.length) {
            newArray[z++] = oddElements[j++];
        }

        return newArray;
    }
}

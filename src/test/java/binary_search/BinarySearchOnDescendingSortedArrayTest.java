package binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchOnDescendingSortedArrayTest {

    @Test
    void findElement() {

        int[] arr = new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 0), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 2), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 3), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 4), 9);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 5), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 6), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 7), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 8), 8);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 9), 7);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, -1), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 100), -1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 14), 3);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 13), 4);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 17), 1);
        Assertions.assertEquals(BinarySearchOnDescendingSortedArray.findElement(arr, 20), 0);

    }
}
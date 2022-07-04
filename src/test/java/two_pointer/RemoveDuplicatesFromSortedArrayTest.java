package two_pointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void removeDuplicate1() {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assertions.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicate_Approach1(arr), 5);
        assertArrayEquals(arr, new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4});
    }

    @Test
    void removeDuplicate2() {
        int[] arr = new int[]{0, 0};
        Assertions.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicate_Approach1(arr), 1);
        assertArrayEquals(arr, new int[]{0, 0});
    }

    @Test
    void removeDuplicate3() {
        int[] arr = new int[]{0, 1};
        Assertions.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicate_Approach1(arr), 2);
        assertArrayEquals(arr, new int[]{0, 1});
    }

    @Test
    void removeDuplicate4() {
        int[] arr = new int[]{1, 1, 2};
        Assertions.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicate_Approach1(arr), 2);
        assertArrayEquals(arr, new int[]{1, 2, 2});
    }
}
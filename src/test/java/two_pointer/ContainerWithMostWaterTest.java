package two_pointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.geeksforgeeks.org/container-with-most-water/
 *
 */
class ContainerWithMostWaterTest {

    @Test
    void containerWithMostWaterTest1() {
        int[] arr = new int[]{1, 5, 4, 3};
        final int water = ContainerWithMostWater.containerWithMostWater(arr);
        Assertions.assertEquals(water, 6);
    }

    @Test
    void containerWithMostWaterTest2() {
        int[] arr = new int[]{3, 1, 2, 4, 5};
        final int water = ContainerWithMostWater.containerWithMostWater(arr);
        Assertions.assertEquals(water, 12);
    }
}
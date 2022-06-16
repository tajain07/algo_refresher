package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestSmallestToRightTest {
    NearestSmallestToRight nearestSmallestToRight = new NearestSmallestToRight();

    @Test
    void nearestSmallestToRightBruteForce() {
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRightBruteForce(new int[]{4, 5, 2, 10, 8}), new int[]{2, 2, -1, 8, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRightBruteForce(new int[]{1, 1, 1, 1, 1}), new int[]{-1, -1, -1, -1, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRightBruteForce(new int[]{1, 2, 3, 4, 5}), new int[]{-1, -1, -1, -1, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRightBruteForce(new int[]{5, 4, 3, 2, 1}), new int[]{4, 3, 2, 1, -1});
    }

    @Test
    void nearestSmallestToRight() {
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRight(new int[]{4, 5, 2, 10, 8}), new int[]{2, 2, -1, 8, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRight(new int[]{1, 1, 1, 1, 1}), new int[]{-1, -1, -1, -1, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRight(new int[]{1, 2, 3, 4, 5}), new int[]{-1, -1, -1, -1, -1});
        Assertions.assertArrayEquals(nearestSmallestToRight.nearestSmallestToRight(new int[]{5, 4, 3, 2, 1}), new int[]{4, 3, 2, 1, -1});

    }
}
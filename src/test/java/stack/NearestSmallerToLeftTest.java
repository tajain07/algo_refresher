package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NearestSmallerToLeftTest {

    NearestSmallestToLeft nearestSmallerToLeft = new NearestSmallestToLeft();

    @Test
    void nearestSmallerToLeftBruteForce() {
        Assertions.assertArrayEquals(nearestSmallerToLeft.nearestSmallestToLeftBruteForce(new int[]{4, 5, 2, 10, 8}), new int[]{-1, 4, -1, 2, 2});
        Assertions.assertArrayEquals(nearestSmallerToLeft.nearestSmallestToLeftBruteForce(new int[]{1, 3, 2, 4 }), new int[]{-1, 1, 1, 2});

    }

    @Test
    void nearestSmallerToLeft() {
        Assertions.assertArrayEquals(nearestSmallerToLeft.nearestSmallestToLeft(new int[]{4, 5, 2, 10, 8}), new int[]{-1, 4, -1, 2, 2});
        Assertions.assertArrayEquals(nearestSmallerToLeft.nearestSmallestToLeft(new int[]{1, 3, 2, 4 }), new int[]{-1, 1, 1, 2});
    }
}
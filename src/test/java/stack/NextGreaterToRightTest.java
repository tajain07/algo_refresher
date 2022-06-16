package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextGreaterToRightTest {
    NextGreaterToRight nextGreaterToRight = new NextGreaterToRight();

    @Test
    void nextGreatestBruteForce() {
        int[] a = {4, 5, 2, 25};
        int[] answer = nextGreaterToRight.nextGreatestBruteForce(a);
        Assertions.assertArrayEquals(answer, new int[]{5, 25, 25, -1});
    }

    @Test
    void nextLargestElement() {
        int[] a = {4, 5, 2, 25};
        int[] answer = nextGreaterToRight.nextLargestElement(a);
        Assertions.assertArrayEquals(answer, new int[]{5, 25, 25, -1});

    }
}
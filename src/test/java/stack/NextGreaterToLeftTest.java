package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NextGreaterToLeftTest {
    NextGreaterToLeft nextGreaterToLeft = new NextGreaterToLeft();

    @Test
    void nextLargestElementToLeft1() {
        int[] a = {1, 3, 2, 4};
        int[] answer = nextGreaterToLeft.nextLargestElementToLeft(a);
        Assertions.assertArrayEquals(answer, new int[]{-1, -1, 3, -1});
    }

    @Test
    void nextLargestElementToLeft2() {
        int[] a = {4, 5, 2, 25};
        int[] answer = nextGreaterToLeft.nextLargestElementToLeft(a);
        Assertions.assertArrayEquals(answer, new int[]{-1, -1, 5, -1});
    }

    @Test
    void nextLargestElementToLeft3() {
        int[] a = {13, 7, 6, 12};
        int[] answer = nextGreaterToLeft.nextLargestElementToLeft(a);
        Assertions.assertArrayEquals(answer, new int[]{-1, 13, 7, 13});
    }

}
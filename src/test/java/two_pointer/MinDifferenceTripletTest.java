package two_pointer;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/
 *
 */
class MinDifferenceTripletTest {

    @Test
    void minDifferenceTest1() {
        final int output = MinDifferenceTriplet.minDifference(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15}, new int[]{2, 3, 6, 6});
        Assertions.assertEquals(output, 1);
    }

    @Test
    void minDifferenceTest2() {
        final int output = MinDifferenceTriplet.minDifference(new int[]{5, 8, 10, 15}, new int[]{6, 9, 15, 78, 89}, new int[]{2, 3, 6, 6, 8, 8, 10 });
        Assertions.assertEquals(output, 1);
    }

}
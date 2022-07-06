package heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberOfPlatformTest {


    @Test
    void input1() {

        int[] arr = new int[]{900, 940, 1200, 1201, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1201, 1201, 1900, 2000};

        int maxPlatformNew = MaxNumberOfPlatform.getMaximumPlatform_Using_Heap(arr, dep);
        Assertions.assertEquals(2, maxPlatformNew);

        int maxPlatform = MaxNumberOfPlatform.getMaximumPlatform_Using_LinkedList(arr, dep);
        Assertions.assertEquals(2, maxPlatform);
    }

    @Test
    void input2() {

        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int maxPlatformNew = MaxNumberOfPlatform.getMaximumPlatform_Using_Heap(arr, dep);
        Assertions.assertEquals(3, maxPlatformNew);

        int maxPlatform = MaxNumberOfPlatform.getMaximumPlatform_Using_LinkedList(arr, dep);
        Assertions.assertEquals(3, maxPlatform);


    }

    @Test
    void input3() {

        int[] arr = new int[]{900, 940};
        int[] dep = new int[]{910, 1200};

        int maxPlatformNew = MaxNumberOfPlatform.getMaximumPlatform_Using_Heap(arr, dep);
        Assertions.assertEquals(1, maxPlatformNew);

        int maxPlatform = MaxNumberOfPlatform.getMaximumPlatform_Using_LinkedList(arr, dep);
        Assertions.assertEquals(1, maxPlatform);
    }


}
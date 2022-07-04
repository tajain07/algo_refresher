package two_pointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void movZeros() {
        Assertions.assertArrayEquals(MoveZeros.movZeros(new int[]{0, 1, 0, 12, 3, 0}), new int[]{1, 12, 3, 0, 0, 0});
        Assertions.assertArrayEquals(MoveZeros.movZeros(new int[]{12, 1, 0, 3, 0}), new int[]{12, 1, 3, 0, 0});
        Assertions.assertArrayEquals(MoveZeros.movZeros(new int[]{0, 1, 0, 12, 3, 0}), new int[]{1, 12, 3, 0, 0, 0});
        Assertions.assertArrayEquals(MoveZeros.movZeros(new int[]{0, 0, 0, 0, 0, 0}), new int[]{0, 0, 0, 0, 0, 0});
    }
}
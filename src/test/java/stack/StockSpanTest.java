package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockSpanTest {

    @Test
    void stockSpan() {

        Assertions.assertArrayEquals(StockSpan.stockSpan(new int[]{100, 60, 70, 65, 80, 85}), new int[]{1, 1, 2, 1, 4, 5});
        Assertions.assertArrayEquals(StockSpan.stockSpan(new int[]{31, 27, 14, 21, 30, 22}), new int[]{1, 1, 1, 2, 4, 1});
    }
}
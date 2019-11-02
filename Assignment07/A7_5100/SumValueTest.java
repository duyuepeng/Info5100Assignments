package A7_5100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumValueTest {
    static long sumTest(int[] arr) {
        long r = 0;
        for (int i = 0; i < arr.length; i++) {
            r += arr[i];
        }
        return r;
    }

    @Test
    void sum() {
        int[] array = new int[4000000];
        SumValue.generateRandomArray(array);
        assertEquals(sumTest(array), SumValue.sum(array));
    }
}
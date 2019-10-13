package A5_5100.Q3;

import static org.junit.jupiter.api.Assertions.*;

class FullTimeTest {
    private final FullTime fullTime = new FullTime("abc", 99);

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("abc", fullTime.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        fullTime.setName("def");
        assertEquals("def", fullTime.getName());
    }

    @org.junit.jupiter.api.Test
    void getPaymentPerHour() {
        assertEquals(99, fullTime.getPaymentPerHour());
    }

    @org.junit.jupiter.api.Test
    void setPaymentPerHour() {
        fullTime.setPaymentPerHour(77);
        assertEquals(77, fullTime.getPaymentPerHour());
    }

    @org.junit.jupiter.api.Test
    void calculateSalary() {
        assertEquals(99*8, fullTime.calculateSalary());
    }
}

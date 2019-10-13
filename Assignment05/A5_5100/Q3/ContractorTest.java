package A5_5100.Q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContractorTest {
    private final Contractor contractor = new Contractor("abc", 99, 7);

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("abc", contractor.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        contractor.setName("def");
        assertEquals("def", contractor.getName());
    }

    @org.junit.jupiter.api.Test
    void getPaymentPerHour() {
        assertEquals(99, contractor.getPaymentPerHour());
    }

    @org.junit.jupiter.api.Test
    void setPaymentPerHour() {
        contractor.setPaymentPerHour(77);
        assertEquals(77, contractor.getPaymentPerHour());
    }

    @org.junit.jupiter.api.Test
    void calculateSalary() {
        assertEquals(99*7, contractor.calculateSalary());
    }
}

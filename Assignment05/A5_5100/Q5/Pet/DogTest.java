package A5_5100.Q5.Pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTest {
    private static String NAME = "Spot";
    private static String OWNER_NAME = "Mary";
    private static String COLOR = "Black and White";
    private static int SEX = Pet.MALE;
    private static String SEX_NAME = "MALE";
    private final Pet pet = new Pet(NAME, OWNER_NAME, COLOR);

    @BeforeEach
    void setUp() {
        pet.setSex(SEX);
    }

    @Test
    void getName() {
        assertEquals(NAME, this.pet.getName());
    }

    @Test
    void getOwnerName() {
        assertEquals(OWNER_NAME, this.pet.getOwnerName());
    }

    @Test
    void getColor() {
        assertEquals(COLOR, this.pet.getColor());
    }

    @Test
    void getSex() {
        assertEquals(SEX_NAME, this.pet.getSex());
    }

    @Test
    void testToString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("%s owned by %s \n" +
                "Color: %s \n" +
                "Sex: %s \n", NAME, OWNER_NAME, COLOR, SEX_NAME);
        assertEquals(sb.toString(), this.pet.toString());
    }
}

package A5_5100.Q5.Dog;

import A5_5100.Q5.Pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {
    private static String NAME = "Spot";
    private static String OWNER_NAME = "Susan";
    private static String COLOR = "White";
    private static String SIZE = "Medium";
    private static int SEX = Pet.SPAYED;
    private static String SEX_NAME = "SPAYED";
    private final Dog dog = new Dog(NAME, OWNER_NAME, COLOR, SIZE);

    @BeforeEach
    void setUp() {
        dog.setSex(SEX);
    }

    @Test
    void getName() {
        assertEquals(NAME, this.dog.getName());
    }

    @Test
    void getOwnerName() {
        assertEquals(OWNER_NAME, this.dog.getOwnerName());
    }

    @Test
    void getColor() {
        assertEquals(COLOR, this.dog.getColor());
    }

    @Test
    void getSex() {
        assertEquals(SEX_NAME, this.dog.getSex());
    }

    @Test
    void getSize() {
        assertEquals(SIZE, this.dog.getSize());
    }

    @Test
    void testToString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("DOG: \n" +
                "%s owned by %s \n" +
                "Color: %s \n" +
                "Sex: %s \n" +
                "Size: %s", NAME, OWNER_NAME, COLOR, SEX_NAME, SIZE);
        assertEquals(sb.toString(), this.dog.toString());
    }

    @Test
    void boarding() {
        this.dog.setBoardStart(12, 1, 2018);
        this.dog.setBoardEnd(12, 1, 2019);
        assertEquals(true, this.dog.boarding(12, 1, 2019));
        assertEquals(true, this.dog.boarding(12, 1, 2018));
        assertEquals(true, this.dog.boarding(4, 15, 2019));
        assertEquals(false, this.dog.boarding(12, 15, 2019));
        assertEquals(false, this.dog.boarding(11, 15, 2018));
    }
}

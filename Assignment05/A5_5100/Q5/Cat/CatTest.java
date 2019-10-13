package A5_5100.Q5.Cat;

import A5_5100.Q5.Pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {
    private static String NAME = "Tom";
    private static String OWNER_NAME = "Bob";
    private static String COLOR = "Black";
    private static String HAIR_LENGTH = "Short";
    private static int SEX = Pet.SPAYED;
    private static String SEX_NAME = "SPAYED";
    private final Cat cat = new Cat(NAME, OWNER_NAME, COLOR, HAIR_LENGTH);

    @BeforeEach
    void setUp() {
        cat.setSex(SEX);
    }

    @Test
    void getName() {
        assertEquals(NAME, this.cat.getName());
    }

    @Test
    void getOwnerName() {
        assertEquals(OWNER_NAME, this.cat.getOwnerName());
    }

    @Test
    void getColor() {
        assertEquals(COLOR, this.cat.getColor());
    }

    @Test
    void getSex() {
        assertEquals(SEX_NAME, this.cat.getSex());
    }

    @Test
    void getHairLength() {
        assertEquals(HAIR_LENGTH, this.cat.getHairLength());
    }

    @Test
    void testToString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("CAT: \n" +
                "%s owned by %s \n" +
                "Color: %s \n" +
                "Sex: %s \n" +
                "Hair: %s", NAME, OWNER_NAME, COLOR, SEX_NAME, HAIR_LENGTH);
        assertEquals(sb.toString(), this.cat.toString());
    }

    @Test
    void boarding() {
        this.cat.setBoardStart(12, 1, 2018);
        this.cat.setBoardEnd(12, 1, 2019);
        assertEquals(true, this.cat.boarding(12, 1, 2019));
        assertEquals(true, this.cat.boarding(12, 1, 2018));
        assertEquals(true, this.cat.boarding(4, 15, 2019));
        assertEquals(false, this.cat.boarding(12, 15, 2019));
        assertEquals(false, this.cat.boarding(11, 15, 2018));
    }
}

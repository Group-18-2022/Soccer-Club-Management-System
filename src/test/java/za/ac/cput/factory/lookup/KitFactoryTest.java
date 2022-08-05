package za.ac.cput.factory.lookup;

/*
 * @author Karl Haupt (220236585)
 * KitFactoryTest.java -> is a testing class that is used to test the KitFactory.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.factory.lookup.KitFactory;

import static org.junit.jupiter.api.Assertions.*;

class KitFactoryTest {
    private Kit kit;

    @BeforeEach
    void setUp() {
        kit = KitFactory.createKit("Away Kit", "Yellow", "Adidas");
    }

    @Test
    public void testKitFactoryCreate() {
        assertNotNull(kit);
    }

    @Test
    public void testValueKitType() {
        assertEquals("Away Kit", kit.getKitType());
    }

    @Test
    public void testValueKitColour() {
        assertEquals("Yellow", kit.getKitColor());
    }

    @Test
    public void testValueKitBrand() {
        assertEquals("Adidas", kit.getKitBrand());
    }

    @Test
    public void testKitFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            KitFactory.createKit(null, null, null);
        });

        String expectedMessage = "Invalid value for params: kitType";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testKitFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            KitFactory.createKit("", "", "");
        });

        String expectedMessage = "Invalid value for params: kitType";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
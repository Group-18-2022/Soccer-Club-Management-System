package za.ac.cput.entity;

/*
 * @author Karl Haupt (220236585)
 * KitTest.java -> is a testing class for the Test domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitTest {
    private Kit kit;

    @BeforeEach
    void setUp() {
        kit = new Kit.Builder().setKitType("Home Kit").setKitColor("Black").setKitBrand("Adidas").build();
    }

    @Test
    public void testKitForNull() {
        assertNotNull(kit);
    }

    @Test
    public void testKitTypeValue() {
        assertEquals("Home Kit", kit.getKitType());
    }

    @Test
    public void testKitColorValue() {
        assertEquals("Black", kit.getKitColor());
    }

    @Test
    public void testKitBrandValue() {
        assertEquals("Adidas", kit.getKitBrand());
    }
}
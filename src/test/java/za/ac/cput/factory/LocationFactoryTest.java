package za.ac.cput.factory;

/*
 * @author Karl Haupt (220236585)
 * LocationFactoryTest.java -> is a testing class that is used to test the LocationFactory class.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Location;
import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {
    private Location location;

    @BeforeEach
    void setUp() {
        location = LocationFactory.createLocation("Cape Town Stadium");
    }

    @Test
    public void testLocationFactoryCreate() {
        assertNotNull(location);
    }

    @Test
    public void testStadiumNameValues() {
        assertEquals("Cape Town Stadium", location.getStadiumName());
    }

    @Test
    public void testLocationFactoryForNull() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            LocationFactory.createLocation(null);
        });

        String expectedMessage = "Invalid value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testLocationFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            LocationFactory.createLocation("");
        });

        String expectedMessage = "Invalid value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
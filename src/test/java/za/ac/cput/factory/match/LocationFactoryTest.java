package za.ac.cput.factory.match;

/*
 * @author Karl Haupt (220236585)
 * LocationFactoryTest.java -> is a testing class that is used to test the LocationFactory class.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {
    private Location location;

    @BeforeEach
    void setUp() {
        location = LocationFactory.createLocation("test-id", "Cape Town Stadium");
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LocationFactory.createLocation(null, null);
        });

        String expectedMessage = "Invalid value for params: locationID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testLocationFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LocationFactory.createLocation("", "");
        });

        String expectedMessage = "Invalid value for params: locationID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
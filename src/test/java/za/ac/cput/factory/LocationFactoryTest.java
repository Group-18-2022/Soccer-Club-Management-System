package za.ac.cput.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {


//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    public void testLocationFactoryCreate() {
        var location = LocationFactory.createLocation("Cape Town Stadium");
        assertNotNull(location);
    }

    @Test
    public void testLocationFactoryValues() {
        var location = LocationFactory.createLocation("Cape Town Stadium");
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
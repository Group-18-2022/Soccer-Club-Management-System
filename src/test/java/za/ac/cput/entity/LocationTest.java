package za.ac.cput.entity;

/*
 * @author Karl Haupt (220236585)
 * LocationTest.java -> is a testing class for the Location domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location.Builder().setLocationId("1").setStadiumName("Cape Town Stadium").build();
    }

    @Test
    public void testLocationForNull() {
        assertNotNull(location);
    }

    @Test
    public void testLocationIDValue() {
        assertEquals("1", location.getLocationId());
    }

    @Test
    public void testStadiumNameValue() {
        assertEquals("Cape Town Stadium", location.getStadiumName());
    }

}
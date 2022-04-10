package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * LocationRepositoryTest.java -> is a testing class for the LocationRepository.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Location;
import za.ac.cput.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LocationRepositoryTest {
    private static LocationRepository repository = LocationRepository.getRepository();;
    private static Location location = LocationFactory.createLocation("Cape Town Stadium");
    private static Location created;

    @BeforeEach
    void setUp() {
        created = repository.create(location);
    }

    @Test
    @Order(1)
    void create() {
        assertNotNull(created);
    }

    @Test @Order(2)
    void read() {
        Location readLocation = repository.read(location.getLocationId());
        assertNotNull(readLocation);
    }

    @Test @Order(3)
    void update() {
        var updatedLocation = new Location.Builder().copy(location).setStadiumName("KZN Stadium").build();
        assertNotNull(repository.update(updatedLocation));
    }

    @Test @Order(4)
    void delete() {
        boolean isSuccessful = repository.delete(location.getLocationId());
        assertTrue(isSuccessful);
    }

    @Test @Order(5)
    void getAll() {
        System.out.println(repository.getAll());
        assertEquals(1, repository.getAll().size());
    }

    @Test @Order(6)
    void contains() {
        boolean hasLocation = repository.contains(location.getLocationId());
        assertTrue(hasLocation);
    }
}
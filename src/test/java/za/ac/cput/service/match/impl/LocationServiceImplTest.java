package za.ac.cput.service.match.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.match.Location;
import za.ac.cput.factory.match.LocationFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationServiceImplTest {
    private Location location;
    @Autowired
    private LocationServiceImpl service;

    @BeforeEach
    void setUp() {
        this.location = LocationFactory.createLocation("test-id", "Cape Town Stadium");
        Location saved = this.service.save(this.location);
        assertEquals(this.location, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.location);
        List<Location> locationList = this.service.findAll();
        assertEquals(0, locationList.size());
    }

    @Test
    void read() {
        Optional<Location> read = this.service.read(location.getLocationId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(location, read.get())
        );
    }

    @Test
    void findAll() {
        List<Location> locationList = this.service.findAll();
        assertEquals(1, locationList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(location.getLocationId());
        List<Location> locationList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, locationList.size())
        );
    }
}
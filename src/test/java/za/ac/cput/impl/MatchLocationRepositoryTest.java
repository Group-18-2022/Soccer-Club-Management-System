package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationRepositoryTest.java -> is a testing class for the MatchLocationRepository.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.entity.MatchLocation;
import za.ac.cput.factory.MatchLocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchLocationRepositoryTest {
    private static MatchLocationRepository repository = MatchLocationRepository.getRepository();;
    private static MatchLocation matchLocation = MatchLocationFactory.createMatchLocation("10", "12");
    private static MatchLocation created;

    @BeforeEach
    void setUp() {
        created = repository.create(matchLocation);
    }

    @Test
    @Order(1)
    void create() {
        assertNotNull(created);
    }

    @Test @Order(2)
    void read() {
        MatchLocation readMatchLocation = repository.read(matchLocation.getLocationId());
        assertNotNull(readMatchLocation);
    }

    @Test @Order(3)
    void update() {
        var updatedMatchLocation = new MatchLocation.Builder().copy(matchLocation).setMatchId("15").build();
        assertNotNull(repository.update(updatedMatchLocation));
    }

    @Test @Order(4)
    void delete() {
        boolean isSuccessful = repository.delete(matchLocation.getLocationId());
        assertTrue(isSuccessful);
    }

    @Test @Order(5)
    void getAll() {
        System.out.println(repository.getAllMatchLocation());
        assertEquals(2, repository.getAllMatchLocation().size());
    }

    @Test @Order(6)
    void contains() {
        boolean hasMatchLocation = repository.contains(matchLocation.getLocationId());
        assertTrue(hasMatchLocation);
    }
}
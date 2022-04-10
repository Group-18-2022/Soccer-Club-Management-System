package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchRepositoryTest.java -> is a testing class for the MatchRepository.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Match;
import za.ac.cput.factory.MatchFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchRepositoryTest {
    private static MatchRepository repository = MatchRepository.getRepository();;
    private static Match match = MatchFactory.createMatch("Team B", "Home Kit", "12 May", "14:00");
    private static Match created;

    @BeforeEach
    void setUp() {
        created = repository.create(match);
    }

    @Test
    @Order(1)
    void create() {
        assertNotNull(created);
    }

    @Test @Order(2)
    void read() {
        Match readMatchLocation = repository.read(match.getMatchId());
        assertNotNull(readMatchLocation);
    }

    @Test @Order(3)
    void update() {
        var updatedMatch = new Match.Builder().copy(match).setOpponent("Team C").setDate("13 May").build();
        assertNotNull(repository.update(updatedMatch));
    }

    @Test @Order(4)
    void delete() {
        boolean isSuccessful = repository.delete(match.getMatchId());
        assertTrue(isSuccessful);
    }

    @Test @Order(5)
    void getAll() {
        System.out.println(repository.getAllMatch());
        assertEquals(2, repository.getAllMatch().size());
    }

    @Test @Order(6)
    void contains() {
        boolean hasMatch = repository.contains(created.getMatchId());
        assertTrue(hasMatch);
    }
}
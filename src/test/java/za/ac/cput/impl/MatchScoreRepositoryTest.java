package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreRepositoryTest.java -> is a testing class for the MatchScoreRepository.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.entity.MatchScore;
import za.ac.cput.factory.MatchScoreFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchScoreRepositoryTest {
    private static MatchScoreRepository repository = MatchScoreRepository.getRepository();
    private static MatchScore matchScore = MatchScoreFactory.createMatchScore("12",  (byte) 4, (byte) 2);
    private static MatchScore created;

    @BeforeEach
    void setUp() {
        created = repository.create(created);
    }

    @Test
    @Order(1)
    void create() {
        assertNotNull(created);
    }

    @Test @Order(2)
    void read() {
        MatchScore readMatchLocation = repository.read(matchScore.getMatchID());
        assertNotNull(readMatchLocation);
    }

    @Test @Order(3)
    void update() {
        byte score= 2;
        var updatedMatchScore = new MatchScore.Builder()
                .copy(matchScore)
                .setMatchID("12")
                .setOpponentScore(score)
                .setTeamScore(score)
                .build();
        assertNotNull(repository.update(updatedMatchScore));
    }

    @Test @Order(4)
    void delete() {
        boolean isSuccessful = repository.delete(matchScore.getMatchID());
        assertTrue(isSuccessful);
    }

    @Test @Order(5)
    void getAll() {
        System.out.println(repository.getAllMatchScore());
        assertEquals(1, repository.getAllMatchScore().size());
    }

    @Test @Order(6)
    void contains() {
        boolean hasMatchScore = repository.contains(matchScore.getMatchID());
        assertTrue(hasMatchScore);
    }
}
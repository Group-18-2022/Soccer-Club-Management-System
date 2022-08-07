package za.ac.cput.service.match.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.factory.match.MatchScoreFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SoccerMatchScoreServiceImplTest {
    private MatchScore matchScore;
    @Autowired
    private MatchScoreServiceImpl service;

    @BeforeEach
    void setUp() {
        this.matchScore = MatchScoreFactory.createMatchScore("1", (byte) 2, (byte) 5);
        MatchScore saved = this.service.save(this.matchScore);
        assertEquals(this.matchScore, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.matchScore);
        List<MatchScore> scores = this.service.findAll();
        assertEquals(0, scores.size());
    }

    @Test
    void read() {
        Optional<MatchScore> read = this.service.read(matchScore.getMatchID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(matchScore, read.get())
        );
    }

    @Test
    void findAll() {
        List<MatchScore> scores = this.service.findAll();
        assertEquals(1, scores.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(matchScore.getMatchID());
        List<MatchScore> scores = this.service.findAll();
        assertAll(
                () -> assertEquals(0, scores.size())
        );
    }
}
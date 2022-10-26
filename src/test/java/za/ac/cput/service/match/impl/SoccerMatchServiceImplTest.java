package za.ac.cput.service.match.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.factory.match.MatchFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SoccerMatchServiceImplTest {
    private SoccerMatch soccerMatch;
    @Autowired
    private MatchServiceImpl service;

    @BeforeEach
    void setUp() {
        this.soccerMatch = MatchFactory.createMatch("test-id", "Team A", "Away Kit", "12 May 2021", "14:00");
        SoccerMatch saved = this.service.save(this.soccerMatch);
        assertEquals(this.soccerMatch, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.soccerMatch);
        List<SoccerMatch> soccerMatchList = this.service.findAll();
        assertEquals(0, soccerMatchList.size());
    }

    @Test
    @Order(1)
    void read() {
        Optional<SoccerMatch> read = this.service.read(soccerMatch.getMatchId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(soccerMatch, read.get())
        );
    }

    @Test
    @Order(2)
    void findAll() {
        List<SoccerMatch> scores = this.service.findAll();
        assertEquals(1, scores.size());
    }

    @Test
    @Order(3)
    void deleteById() {
        this.service.deleteById(soccerMatch.getMatchId());
        List<SoccerMatch> scores = this.service.findAll();
        assertAll(
                () -> assertEquals(0, scores.size())
        );
    }
}
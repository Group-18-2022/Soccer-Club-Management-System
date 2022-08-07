package za.ac.cput.api.match;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.lookup.MatchLocation;
import za.ac.cput.factory.match.MatchLocationFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SoccerMatchLocationAPITest {

    @Autowired private MatchLocationAPI api;

    private MatchLocation matchLocation = MatchLocationFactory.createMatchLocation("1", "1");


    @Test
    void save() {
        MatchLocation saved = this.api.save(matchLocation);
        assertNotNull(saved);
    }
}
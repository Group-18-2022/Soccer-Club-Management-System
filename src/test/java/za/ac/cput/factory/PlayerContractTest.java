package za.ac.cput.factory;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.PlayerContract;
import static org.junit.jupiter.api.Assertions.*;

class PlayerContractTest {
    private PlayerContract playerContract;

    @BeforeEach
    void setUp() {
        playerContract = PlayerContractFactory.createPlayerContract(1, 3, 2);
    }

    @Test
    public void testPlayerContractFactoryCreate() {
        assertNotNull(playerContract);
    }

    @Test
    public void testValueContractid() {
        assertEquals(1, playerContract.getContractid());
    }

    @Test
    public void testValueGoalTarget() {

        assertEquals(3, playerContract.getGoalTarget());
    }

    @Test
    public void testValueMatchesPlayed() {

        assertEquals(2, playerContract.getMatchesPlayed());
    }

    @Test
    public void testPlayerContractFactoryForNull() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            PlayerContractFactory.createplayerContract(null, null, null);
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPlayerContractFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            PlayerContractFactory.createPlayerContract( , , );
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
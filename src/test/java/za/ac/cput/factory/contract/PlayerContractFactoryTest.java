/*
Mponeng Ratego
216178991
Assignment 1
 */

package za.ac.cput.factory.contract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.contract.PlayerContract;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerContractFactoryTest {

    PlayerContract playerContract;

    @BeforeEach
    public void setUp() {playerContract= PlayerContractFactory.createPlayerContract("257", 3, 4, null);}

    @Test
    public void createPlayerContractTest()
    {
        playerContract = PlayerContractFactory.createPlayerContract("257",3, 4,null);
        assertNotNull(playerContract);

    }

    @Test
    public void idContractTest()
    {
        assertEquals("257", playerContract.getContractId());
    }
}



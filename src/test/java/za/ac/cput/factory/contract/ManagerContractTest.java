/*
Mponeng Ratego
216178991
Assignment 1
 */

package za.ac.cput.factory.contract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.contract.ManagerContract;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerContractTest {

    ManagerContract managerContract;

    @BeforeEach
    public void setUp() {managerContract= ManagerContractFactory.createManagerContract("256", "4 Lap", 1, null);}

    @Test
    public void idContractTest()
    {
        assertEquals("256", managerContract.getContractId());
    }

    @Test
    public void mileStoneTest()
    {
        assertEquals("4 Lap", managerContract.getMilestonesOnTime());

    }
}

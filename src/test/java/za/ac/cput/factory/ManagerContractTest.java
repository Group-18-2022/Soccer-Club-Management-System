package za.ac.cput.factory;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ManagerContract;
import static org.junit.jupiter.api.Assertions.*;

class ManagerContractTest {
    private ManagerContract ManagerContract;

    @BeforeEach
    void setUp() {
        managerContract = ManagerContractFactory.createManagerContract(1, 3, 2);
    }

    @Test
    public void testManagerContractFactoryCreate() {
        assertNotNull(managerContract);
    }

    @Test
    public void testValueContractid() {
        assertEquals(1, managerContract.getContractid());
    }

    @Test
    public void testMilestonesOnTime() {

        assertEquals(3, managerContract.getMilestonesOnTime());
    }

    @Test
    public void testNumberOfGrievyances() {

        assertEquals(2, managerContract.getNumberOfGrievyances());
    }

    @Test
    public void testManagerContractFactoryForNull() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            ManagerContractFactory.createplayerContract(null, null, null);
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testManagerContractFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            ManagerContractFactory.createManagerContract( , , );
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
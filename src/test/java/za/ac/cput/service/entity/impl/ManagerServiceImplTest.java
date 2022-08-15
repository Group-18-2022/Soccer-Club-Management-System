package za.ac.cput.service.entity.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.factory.entity.ManagerFactory;
import za.ac.cput.factory.entity.PlayerFactory;
import za.ac.cput.service.entity.ManagerServiceInterface;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerServiceImplTest
{
    private Manager manager;

    @Autowired
    private ManagerServiceImpl managerService;

    @BeforeEach
    void setUp()
    {
        PersonalDetails pd = new PersonalDetails.Builder()
                .setFirstName("yyy").setIdNumber("xxx").setSurname("zzz").build();

        this.manager = ManagerFactory.createManager
                ("00001", "Scissorhands"
                        , "Marketing Manager", 10, pd);

        Manager saved = this.managerService.save(this.manager);
        assertEquals(this.manager, saved);
    }

    @AfterEach
    void tearDown()
    {
        this.managerService.delete(this.manager);
        List<Manager> managerList = this.managerService.readAll();
        assertEquals(0, managerList.size());
    }

    @Test
    void read() {
        Optional<Manager> read = this.managerService.read(manager.getEmpNumber());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(manager, read.get())
        );
    }

    @Test
    void findAll() {
        List<Manager> managerList = this.managerService.readAll();
        assertEquals(1, managerList.size());
    }

    @Test
    void deleteById() {
        this.managerService.deleteById(manager.getEmpNumber());
        List<Manager> managerList = this.managerService.readAll();
        assertAll(
                () -> assertEquals(0, managerList.size())
        );
    }
}
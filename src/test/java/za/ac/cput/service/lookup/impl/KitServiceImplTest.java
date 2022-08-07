package za.ac.cput.service.lookup.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.factory.lookup.KitFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KitServiceImplTest {
    private Kit kit;
    @Autowired
    private KitServiceImpl service;

    @BeforeEach
    void setUp() {
        this.kit = KitFactory.createKit("Away Kit", "Yellow", "Adidas");
        Kit saved = this.service.save(this.kit);
        assertEquals(this.kit, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.kit);
        List<Kit> kitList = this.service.findAll();
        assertEquals(0, kitList.size());
    }

    @Test
    void read() {
        Optional<Kit> read = this.service.read(kit.getKitType());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(kit, read.get())
        );
    }

    @Test
    void findAll() {
        List<Kit> kitList = this.service.findAll();
        assertEquals(1, kitList.size());
    }

    @Test
    void deleteById() {
        this.service.deleteById(kit.getKitType());
        List<Kit> employeeList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, employeeList.size())
        );
    }
}
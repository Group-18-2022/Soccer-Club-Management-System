package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * KitRepositoryTest.java -> is a testing class for the KitRepository.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Kit;
import za.ac.cput.factory.KitFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KitRepositoryTest {
    private static KitRepository repository = KitRepository.getRepository();
    private static Kit kit = KitFactory.createKit("Home Kit", "Black", "Adidas");;
    private static Kit created;

    @BeforeEach
    void setUp() {
        created = repository.create(kit);
    }

    @Test @Order(1)
    void createNull() {
        assertNotNull(created);
    }

    @Test @Order(2)
    void read() {
        Kit readKit = repository.read("Home Kit");
        assertNotNull(readKit);
    }

    @Test @Order(3)
    void update() {
        var updatedKit = new Kit.Builder().copy(kit).setKitType(kit.getKitType()).setKitColor("Red").setKitBrand("Nike").build();
        assertNotNull(repository.update(updatedKit));
    }

    @Test @Order(4)
    void delete() {
        boolean isSuccessful = repository.delete(kit.getKitType());
        assertTrue(isSuccessful);
    }

    @Test @Order(5)
    void getAllKits() {
        System.out.println(repository.getAllKits());
        assertEquals(2, repository.getAllKits().size());
    }

    @Test @Order(6)
    void contains() {
        boolean hasKit = repository.contains("Home Kit");
        assertTrue(hasKit);
    }
}
package za.ac.cput.service.entity.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.domain.match.Location;
import za.ac.cput.factory.entity.PlayerFactory;
import za.ac.cput.factory.match.LocationFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerServiceImplTest
{
    private Player player;

    @Autowired
    private PlayerServiceImpl playerService;

    @BeforeEach
    void setUp()
    {
        PersonalDetails pd = new PersonalDetails.Builder()
                .setFirstName("yyy").setIdNumber("xxx").setSurname("zzz").build();

        this.player = PlayerFactory.createPlayer
                ("00001", 04, 01, "A01", pd);

        Player saved = this.playerService.save(this.player);
        assertEquals(this.player, saved);
    }

    @AfterEach
    void tearDown()
    {
        this.playerService.delete(this.player);
        List<Player> playerList = this.playerService.readAll();
        assertEquals(0, playerList.size());
    }

    @Test
    void read() {
        Optional<Player> read = this.playerService.read(player.getEmpNumber());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(player, read.get())
        );
    }

    @Test
    void findAll() {
        List<Player> playerList = this.playerService.readAll();
        assertEquals(1, playerList.size());
    }

    @Test
    void deleteById() {
        this.playerService.deleteById(player.getEmpNumber());
        List<Player> playerList = this.playerService.readAll();
        assertAll(
                () -> assertEquals(0, playerList.size())
        );
    }
}
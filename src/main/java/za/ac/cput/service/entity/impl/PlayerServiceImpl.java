/*
Author: Trevor Ngcobo (220477019)
Subject: Applications Development Practice 3
Group: 18
Assessment: Capstone Project 2022
*/

package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.repository.entity.PlayerRepository;
import za.ac.cput.service.entity.PlayerServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerServiceInterface
{
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public Optional<Player> read(String s) {
        return this.playerRepository.findById(s);
    }

    @Override
    public void delete(Player player) {
        this.playerRepository.delete(player);
    }

    @Override
    public List<Player> readAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        this.playerRepository.deleteById(id);

    }

    @Override
    public Optional<Player> findPlayerByByNameAndEmail(String name, String email) {
        var player = this.playerRepository.findPlayerByByNameAndEmail(name, email);
        System.out.println("Player, " + player.get());
        return player;
    }
}

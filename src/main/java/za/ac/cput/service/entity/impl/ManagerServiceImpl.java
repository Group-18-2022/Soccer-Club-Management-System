/*
Author: Trevor Ngcobo (220477019)
Subject: Applications Development Practice 3
Group: 18
Assessment: Capstone Project 2022
*/

package za.ac.cput.service.entity.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.repository.entity.ManagerRepository;
import za.ac.cput.service.entity.ManagerServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerServiceInterface
{
    private ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager save(Manager manager) {
        return this.managerRepository.save(manager);
    }

    @Override
    public Optional<Manager> read(String s) {
        return this.managerRepository.findById(s);
    }

    @Override
    public void delete(Manager manager) {
        this.managerRepository.delete(manager);
    }

    @Override
    public List<Manager> readAll() {
        return this.managerRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        this.managerRepository.deleteById(id);
    }

    @Override
    public Optional<Manager> findManagerByByNameAndEmail(String name, String email) {
        return this.managerRepository.findManagerByByNameAndEmail(name, email);
    }
}

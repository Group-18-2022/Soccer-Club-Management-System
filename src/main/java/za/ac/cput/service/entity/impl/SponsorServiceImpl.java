package za.ac.cput.service.entity.impl;

/* SponsorServiceImpl.java
   Service Implementation for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Sponsor;
import za.ac.cput.repository.entity.SponsorRepository;
import za.ac.cput.service.entity.SponsorService;

import java.util.List;
import java.util.Optional;

public class SponsorServiceImpl implements SponsorService {
    private SponsorRepository repository;

    @Autowired
    public SponsorServiceImpl(SponsorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sponsor save(Sponsor sponsor) {
        return this.repository.save(sponsor);
    }

    @Override
    public Optional<Sponsor> read(String roleID) {
        return this.repository.findById(roleID);
    }

    @Override
    public void delete(Sponsor sponsor) {
        this.repository.delete(sponsor);
    }

    @Override
    public void deleteByID(String roleID) {
        this.repository.deleteById(roleID);
    }

    @Override
    public List<Sponsor> findAll() {
        return this.repository.findAll();
    }
}

package za.ac.cput.service.lookup.impl;

/*
 * @author Karl Haupt (220236585)
 * KitServiceImpl.java -> is a class that communicates with the Kit Repository
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.repository.lookup.KitRepository;
import za.ac.cput.service.lookup.KitService;

import java.util.List;
import java.util.Optional;

@Service
public class KitServiceImpl implements KitService {
    private KitRepository repository;

    @Autowired
    public KitServiceImpl(KitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Kit save(Kit kit) {
        return this.repository.save(kit);
    }

    @Override
    public Optional<Kit> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Kit kit) {
        this.repository.delete(kit);
    }

    public void deleteById(String ID) {
        this.repository.deleteById(ID);
    }

    public List<Kit> findAll() {
        return this.repository.findAll();
    }
}

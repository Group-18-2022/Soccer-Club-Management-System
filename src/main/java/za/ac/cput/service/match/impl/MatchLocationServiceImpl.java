package za.ac.cput.service.match.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationServiceImpl.java -> is a class that communicates with the MatchLocation Repository
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.match.MatchLocation;
import za.ac.cput.repository.match.MatchLocationRepository;
import za.ac.cput.service.match.MatchLocationService;

import java.util.List;
import java.util.Optional;


@Service
public class MatchLocationServiceImpl implements MatchLocationService {
    private MatchLocationRepository repository;

    @Autowired
    public MatchLocationServiceImpl(MatchLocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchLocation save(MatchLocation matchLocation) {
        return this.repository.save(matchLocation);
    }

    @Override
    public Optional<MatchLocation> read(MatchLocation.MatchLocationID matchLocationID) {
        return this.repository.findById(matchLocationID);
    }

    @Override
    public void delete(MatchLocation matchLocation) {
        this.repository.delete(matchLocation);
    }

    @Override
    public List<MatchLocation> findAll() {
        return this.repository.findAll();
    }
}

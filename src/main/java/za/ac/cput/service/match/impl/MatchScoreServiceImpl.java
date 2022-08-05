package za.ac.cput.service.match.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreServiceImpl.java -> is a class that communicates with the SoccerMatch Score Repository
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.repository.match.MatchScoreRepository;
import za.ac.cput.service.match.MatchScoreService;

import java.util.List;
import java.util.Optional;

@Service
public class MatchScoreServiceImpl implements MatchScoreService {
    private MatchScoreRepository repository;

    @Autowired
    public MatchScoreServiceImpl(MatchScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchScore save(MatchScore matchScore) {
        return this.repository.save(matchScore);
    }

    @Override
    public Optional<MatchScore> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(MatchScore matchScore) {
        this.repository.delete(matchScore);
    }

    @Override
    public void deleteById(String ID) {
        this.repository.deleteById(ID);
    }

    @Override
    public List<MatchScore> findAll() {
        return this.repository.findAll();
    }
}

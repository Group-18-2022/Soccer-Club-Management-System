package za.ac.cput.service.match.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchServiceImpl.java -> is a class that communicates with the SoccerMatch Repository
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.repository.match.MatchRepository;
import za.ac.cput.service.match.MatchService;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository repository;

    @Autowired
    public MatchServiceImpl(MatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public SoccerMatch save(SoccerMatch soccerMatch) {
        return this.repository.save(soccerMatch);
    }

    @Override
    public Optional<SoccerMatch> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(SoccerMatch soccerMatch) {
        this.repository.delete(soccerMatch);
    }

    @Override
    public void deleteById(String ID) {
        this.repository.deleteById(ID);
    }

    @Override
    public List<SoccerMatch> findAll() {
        return this.repository.findAll();
    }
}

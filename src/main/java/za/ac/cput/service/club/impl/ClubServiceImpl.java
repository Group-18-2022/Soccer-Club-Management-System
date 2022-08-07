package za.ac.cput.service.club.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.club.Club;
import za.ac.cput.repository.club.ClubRepository;
import za.ac.cput.service.club.ClubService;

import java.util.List;
import java.util.Optional;

/**
 * This is the Club Services
 * @author Charles Moses Lemmert (220498385)
 * **/
@Service
public class ClubServiceImpl  implements ClubService {

    private ClubRepository clubRepo;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepo){
        this.clubRepo = clubRepo;
    }
    @Override
    public Club save(Club club) {
        return this.clubRepo.save(club);
    }

    @Override
    public Optional<Club> read(String id) {
        return this.clubRepo.findById(id);
    }
    @Override
    public void deleteById(String id) {
        this.clubRepo.deleteById(id);
    }
    @Override
    public void delete(Club club) {
        this.clubRepo.delete(club);
    }

    @Override
    public List<Club> findAllClubs() {
        return this.clubRepo.findAll();
    }
}

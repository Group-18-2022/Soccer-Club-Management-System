package za.ac.cput.service.club;

import za.ac.cput.domain.club.Club;
import za.ac.cput.service.IService;

import java.util.List;

/**
 * This is the Club Services interface
 * @author Charles Moses Lemmert (220498385)
 * **/
public interface ClubService extends IService<Club, String> {
    List<Club> findAllClubs();
    void deleteById(String id);
}

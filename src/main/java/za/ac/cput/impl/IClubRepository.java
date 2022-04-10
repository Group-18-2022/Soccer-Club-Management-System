package za.ac.cput.impl;
/**
 * This is the Club Repository Interface
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/
import za.ac.cput.entity.Club;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IClubRepository extends IRepository<Club, String> {

    Set<Club> getAll();

}

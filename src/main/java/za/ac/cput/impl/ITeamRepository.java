/**
 * ITeamRepository.java
 * This is the ITeamRepository
 * @author Mike Somelezo Tyolani (220187568)
 * 08 April 2022
 */
package za.ac.cput.impl;

import za.ac.cput.entity.Team;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ITeamRepository extends IRepository<Team, String> {

    public Set<Team> getAll();
}

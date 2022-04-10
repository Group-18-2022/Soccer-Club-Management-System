/**
 * ITeamStatisticsRepository.java
 * This is the ITeamStatisticsRepository
 * @author Mike Somelezo Tyolani (220187568)
 * 08 April 2022
 */
package za.ac.cput.impl;

import za.ac.cput.entity.TeamStatistics;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ITeamStatisticsRepository extends IRepository<TeamStatistics, String> {

    public Set<TeamStatistics> getAll();
}

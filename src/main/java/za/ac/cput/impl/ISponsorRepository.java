package za.ac.cput.impl;

/* ISponsorRepository.java
   IRepository for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.entity.Sponsor;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ISponsorRepository extends IRepository<Sponsor, String> {
    public Set<Sponsor> getAll();
}

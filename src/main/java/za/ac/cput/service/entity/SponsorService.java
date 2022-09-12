package za.ac.cput.service.entity;

/* SponsorService.java
   Service Interface for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import za.ac.cput.domain.Sponsor;
import za.ac.cput.service.IService;

import java.util.List;

public interface SponsorService extends IService<Sponsor, String> {
    void deleteByID(String roleID);
    List<Sponsor> findAll();
}

package za.ac.cput.repository.entity;

/* SponsorRepository.java
   Repository for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 07/08/2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, String> {
}

/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.contract.PlayerContract;

@Repository
public interface PlayerContractRepository extends JpaRepository<PlayerContract, String> {
}

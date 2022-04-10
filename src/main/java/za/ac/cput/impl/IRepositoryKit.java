package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * IRepositoryKit.java -> is an interface that is used by KitRepository.
 */

import za.ac.cput.entity.Kit;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryKit extends IRepository<Kit, String> {
    Set<Kit> getAllKits();
    boolean contains(String kitType);
}

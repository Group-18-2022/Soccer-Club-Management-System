package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * KitRepository.java -> is a class that performs CRUD operations on the Kit domain.
 */

import za.ac.cput.entity.Kit;

import java.util.HashSet;
import java.util.Set;

public class KitRepository implements IRepositoryKit {
    private static KitRepository repository = null;
    private Set<Kit> kitDB;

    private KitRepository() {
        this.kitDB = new HashSet<>();
    }

    public static KitRepository getRepository() {
        if(repository == null) repository = new KitRepository();
        return repository;
    }

    @Override
    public Kit create(Kit kit) {
        boolean isSuccessful = kitDB.add(kit);
        if(!isSuccessful) return null;
        return kit;
    }

    @Override
    public Kit read(String kitType) {
        var kit = kitDB.stream()
                .filter(k -> k.getKitType().equals(kitType))
                .findAny().orElse(null);
        return kit;
    }

    @Override
    public Kit update(Kit kit) {
        var currentKit = read(kit.getKitType());
        if(currentKit != null) {
            kitDB.remove(currentKit);
            kitDB.add(kit);
            return kit;
        }
        return null;
    }

    @Override
    public boolean delete(String kitType) {
        boolean isSuccessful = true;
        var kitToDelete = read(kitType);
        if(kitToDelete != null) isSuccessful = kitDB.remove(kitToDelete);
        return isSuccessful;
    }

    @Override
    public Set<Kit> getAllKits() {
        return kitDB;
    }

    @Override
    public boolean contains(String kitType) {
        var kit = read(kitType);
        if(kit != null) return true;
        return false;
    }
}

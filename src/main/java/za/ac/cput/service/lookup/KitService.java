package za.ac.cput.service.lookup;

import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.service.IService;

import java.util.List;

public interface KitService extends IService<Kit, String> {
    void deleteById(String id);
    List<Kit> findAll();
}

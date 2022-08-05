package za.ac.cput.service;

import java.util.Optional;

public interface IService<T, ID> {
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}

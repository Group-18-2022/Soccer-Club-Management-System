package za.ac.cput.repository;

public interface IRepository<T, ID> {
    T create(T t);
    T read(T t);
    T update(T t);
    boolean delete(ID id);
}

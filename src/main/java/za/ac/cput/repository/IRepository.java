package za.ac.cput.repository;

public interface IRepository<T, ID> {
    T create(T t);
    T read(String t);
    T update(T t);
    boolean delete(ID id);
}

package uz.pdp.firstHomeworkWithGit.db;

import java.util.List;

public interface Repository<T> {
    void save(T t);
    void update(T t);
    List<T> findAll();
    void delete(T t);
}

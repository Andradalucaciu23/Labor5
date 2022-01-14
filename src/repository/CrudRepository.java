package repository;

import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

public interface CrudRepository<T> {
/*
    T findOne(int id) throws IOException, ClassNotFoundException;
    List<T> findAll() throws IOException, ClassNotFoundException;
    T save(T entity) throws IOException, SQLException;
    void delete(T entity) throws IOException, SQLException;
    T update(T entity) throws IOException, ClassNotFoundException, SQLException;

    */
T   findOne(long id) throws SQLException;
    List<T> findAll() throws  SQLException;
    T save(T entity) throws  SQLException;
    void delete(T entity) throws  SQLException;
    T update(T entity) throws  SQLException;


}


/*package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements CrudRepository<T> {
    protected List<T> repoList;



    public InMemoryRepository(){
        this.repoList =  new ArrayList<>();
    }

    @Override
    public T findOne(int id){
        return this.repoList.get(id);
    }

    @Override
    public List<T> findAll() throws SQLException {
        return this.repoList;
    }

    @Override
    public T save(T entity) throws SQLException {
        this.repoList.add(entity);
        return entity;
    }

    @Override
    public void delete(T entity) throws SQLException {
        this.repoList.remove(entity);
    }


}
*/
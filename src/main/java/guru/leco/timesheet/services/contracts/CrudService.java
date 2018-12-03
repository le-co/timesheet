package guru.leco.timesheet.services.contracts;

import java.util.List;

public interface CrudService<T, ID> {

    T saveOrUpdate(T object);

    T findById(ID id);

    List<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}

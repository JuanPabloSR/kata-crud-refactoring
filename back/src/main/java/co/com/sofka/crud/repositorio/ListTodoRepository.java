package co.com.sofka.crud.repositorio;

import co.com.sofka.crud.entidades.ListTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListTodoRepository extends CrudRepository<ListTodo,Long> {

}

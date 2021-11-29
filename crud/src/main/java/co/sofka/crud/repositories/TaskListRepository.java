package co.sofka.crud.repositories;

import co.sofka.crud.models.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {

}
package co.com.sofka.crud.servicios;

import co.com.sofka.crud.entidades.ListTodo;
import co.com.sofka.crud.entidades.Todo;
import co.com.sofka.crud.entidades.dtos.DTOentidadListTodo;
import co.com.sofka.crud.entidades.dtos.DTOentidadTodo;
import co.com.sofka.crud.entidades.dtos.ListTodoDto;
import co.com.sofka.crud.entidades.dtos.TodoDto;
import co.com.sofka.crud.repositorio.TodoRepository;
import co.com.sofka.crud.util.DtoUtilsListTodo;
import co.com.sofka.crud.util.DtoUtilsTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;


//    public Iterable<Todo> list(){
//        return repository.findAll();
//    }
    public Iterable<DTOentidadTodo> list(){
        return ((List<Todo>) repository.findAll()).stream().map(obj -> new DtoUtilsTodo().convertToDto(obj, new TodoDto()))
                .collect(Collectors.toList());
    
    }

//    public Todo save(Todo todo){
//        return repository.save(todo);
//    }
    public  DTOentidadTodo save(DTOentidadTodo dtoentidadTodo){
        Todo lt=(Todo) new DtoUtilsTodo().convertToEntity(new Todo(),dtoentidadTodo);
        return new DtoUtilsTodo().convertToDto(repository.save(lt),new TodoDto());
    }

//    public void delete(Long id){
//        repository.delete(get(id));
//    }
    public  void  delete(Long id){
        Todo lt=(Todo) new DtoUtilsTodo().convertToEntity(new Todo(), get(id));
        repository.delete(lt);
    }

//    public Todo get(Long id){
//         return repository.findById(id).orElseThrow();
//    }
    public DTOentidadTodo get(Long id){
        return repository.findById(id).map(obj -> new DtoUtilsTodo().convertToDto(obj, new TodoDto())).orElseThrow();
    }

    /*public Iterable<Todo> listporlist(String grouplistid){
        return repository.findByGroupListId(grouplistid);
    }
    public void deleteGrouplistid(String grouplistid){
        repository.deleteGroupListId(grouplistid);
    }*/
}

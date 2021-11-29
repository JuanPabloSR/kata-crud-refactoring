package co.com.sofka.crud.servicios;

import co.com.sofka.crud.entidades.ListTodo;
import co.com.sofka.crud.entidades.dtos.DTOentidadListTodo;
import co.com.sofka.crud.entidades.dtos.ListTodoDto;
import co.com.sofka.crud.entidades.dtos.TodoDto;
import co.com.sofka.crud.repositorio.ListTodoRepository;

import co.com.sofka.crud.util.DtoUtilsListTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTodoService {
    @Autowired
    private ListTodoRepository repository;




    //    public Iterable<ListTodo> list(){
//        return repository.findAll();
//    }
    public Iterable<DTOentidadListTodo> list(){
        return ((List<ListTodo>) repository.findAll()).stream().map(obj -> new DtoUtilsListTodo().convertToDto(obj, new ListTodoDto()))
                .collect(Collectors.toList());

    }

//    public ListTodo save(ListTodo listTodo){
//        return repository.save(listTodo);
//    }
    public  DTOentidadListTodo save(DTOentidadListTodo dtoentidadListTodo){
        ListTodo lt=(ListTodo) new DtoUtilsListTodo().convertToEntity(new ListTodo(),dtoentidadListTodo);
        return new DtoUtilsListTodo().convertToDto(repository.save(lt),new ListTodoDto());
    }

//    public void delete(Long id){

//        repository.delete(get(id));
//    }
    public  void  delete(Long id){
        ListTodo lt=(ListTodo) new DtoUtilsListTodo().convertToEntity(new ListTodo(), get(id));
        repository.delete(lt);
    }
    public DTOentidadListTodo get(Long id){
        return repository.findById(id).map(obj -> new DtoUtilsListTodo().convertToDto(obj, new ListTodoDto())).orElseThrow();
    }


}

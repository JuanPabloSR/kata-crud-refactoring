package co.com.sofka.crud.controlador;

import co.com.sofka.crud.entidades.Todo;
import co.com.sofka.crud.entidades.dtos.DTOentidadTodo;
import co.com.sofka.crud.entidades.dtos.TodoDto;
import co.com.sofka.crud.servicios.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<DTOentidadTodo> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public DTOentidadTodo save(@RequestBody TodoDto todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public DTOentidadTodo update(@RequestBody TodoDto todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public DTOentidadTodo get(@PathVariable("id") Long id){
        return service.get(id);
    }

//    @GetMapping(value="api/todos/{grouplistid}")
//    public Iterable<Todo> getlist(@PathVariable("grouplistid") String grouplistid){
//        return service.listporlist(grouplistid);
//    }
//    @DeleteMapping(value = "api/groups/{grouplistid}")
//    public void  deletegroup(@PathVariable ("grouplistid") String grouplistid){
//        service.deleteGrouplistid(grouplistid);
//    }
}

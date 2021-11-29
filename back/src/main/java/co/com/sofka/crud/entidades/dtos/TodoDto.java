package co.com.sofka.crud.entidades.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class TodoDto implements DTOentidadTodo {

    private Long id;
    private String name;
    private boolean completed;
    private Long listtodo;

    public TodoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getListtodo() {
        return listtodo;
    }

    public void setListtodo(Long listtodo) {
        this.listtodo = listtodo;
    }
}

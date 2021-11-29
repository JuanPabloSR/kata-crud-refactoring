package co.com.sofka.crud.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "El campo no puede estar vacio")
    private String name;
    private boolean completed;

    @JoinColumn(nullable = false)
    private Long listtodo;


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

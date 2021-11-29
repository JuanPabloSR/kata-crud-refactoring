package co.com.sofka.crud.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Entity
public class ListTodo {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "El campo no puede estar vacio")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "listtodo")
    private Set<Todo> Listtodo;

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

    public Set<Todo> getListtodo() {
        return Listtodo;
    }

    public void setListtodo(Set<Todo> listtodo) {
        Listtodo = listtodo;
    }
}

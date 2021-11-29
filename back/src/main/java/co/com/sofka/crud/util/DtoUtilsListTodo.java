package co.com.sofka.crud.util;

import co.com.sofka.crud.entidades.ListTodo;
import co.com.sofka.crud.entidades.dtos.DTOentidadListTodo;
import co.com.sofka.crud.entidades.dtos.DTOentidadTodo;
import co.com.sofka.crud.entidades.dtos.ListTodoDto;
import org.modelmapper.ModelMapper;

public class DtoUtilsListTodo {

    public DTOentidadListTodo convertToDto(Object obj, DTOentidadListTodo mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOentidadListTodo mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }
}

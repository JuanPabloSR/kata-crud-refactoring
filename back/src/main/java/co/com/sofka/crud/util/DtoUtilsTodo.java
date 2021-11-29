package co.com.sofka.crud.util;

import co.com.sofka.crud.entidades.dtos.DTOentidadTodo;
import org.modelmapper.ModelMapper;

public class DtoUtilsTodo {

    public DTOentidadTodo convertToDto(Object obj, DTOentidadTodo mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOentidadTodo mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }
}

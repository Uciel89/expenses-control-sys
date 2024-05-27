package com.expenses.control.sys.api.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter <E,D>{
    public abstract D fromEntity(E entity);
    public abstract E fromDto(D dto);

    public List<D> fromEntityList (List<E> entityList){
        return entityList.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    };
    public List<E> fromDto(List<D> dtosList){
        return dtosList.stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }

}

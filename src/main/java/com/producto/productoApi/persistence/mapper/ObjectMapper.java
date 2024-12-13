package com.producto.productoApi.persistence.mapper;

import com.producto.productoApi.domain.dto.Object;
import com.producto.productoApi.persistence.Entity.Objeto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    @Mappings({@Mapping(source ="nombre",target = "name"),})
    Object toObject(Objeto objeto);
    List<Object> toObjects(List<Objeto> objeto);

    @InheritInverseConfiguration
    Objeto toObjeto(Object objeto);
}

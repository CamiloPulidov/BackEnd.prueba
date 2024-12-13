package com.producto.productoApi.persistence.crud;

import com.producto.productoApi.persistence.Entity.Objeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjetoCrudRepository extends CrudRepository<Objeto, Integer> {


    Objeto findByIdOrderByNombreAsc(String id);



}

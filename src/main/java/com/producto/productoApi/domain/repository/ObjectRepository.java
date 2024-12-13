package com.producto.productoApi.domain.repository;

import com.producto.productoApi.domain.dto.Object;
import java.util.List;

public interface ObjectRepository {
    Object findById(String id);
    List<Object> getAll();
    Object save(Object object);
    void delete(String id);

    String getNextId();
}

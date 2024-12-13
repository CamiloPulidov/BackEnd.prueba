package com.producto.productoApi.domain.service;

import com.producto.productoApi.domain.dto.Object;
import com.producto.productoApi.domain.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService {
    @Autowired
    private ObjectRepository objectRepository;

    public Object findById(String id){
        return objectRepository.findById(id);
    }

    public List<Object> getAll() {
        return objectRepository.getAll();
    }

    public Object save(Object employee) {
        return objectRepository.save(employee);
    }

    public void delete(String id) {
        objectRepository.delete(id);
    }

    public String getNextId() {
        return objectRepository.getNextId();
    }

}

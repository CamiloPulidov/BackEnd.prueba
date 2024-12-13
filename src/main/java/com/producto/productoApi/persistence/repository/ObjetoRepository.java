package com.producto.productoApi.persistence.repository;

import com.producto.productoApi.domain.dto.Object;
import com.producto.productoApi.domain.repository.ObjectRepository;
import com.producto.productoApi.persistence.Entity.Objeto;
import com.producto.productoApi.persistence.crud.ObjetoCrudRepository;
import com.producto.productoApi.persistence.mapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjetoRepository implements ObjectRepository {

    @Autowired
    private ObjetoCrudRepository objetoCrudRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public Object findById(String id) {
        Objeto objeto=objetoCrudRepository.findByIdOrderByNombreAsc(id);
        return mapper.toObject(objeto);
    }

    @Override
    public List<Object> getAll() {
        List<Objeto> objetos=(List<Objeto>) objetoCrudRepository.findAll();
        return mapper.toObjects(objetos);
    }

    @Override
    public Object save(Object object) {
        Objeto objeto=mapper.toObjeto(object);
        Objeto newObjeto=objetoCrudRepository.save(objeto);
        return mapper.toObject(newObjeto);

    }

    @Override
    public void delete(String id) {
        Object DeleteEmployee=findById(id);
        objetoCrudRepository.delete(mapper.toObjeto(DeleteEmployee));
    }

    public String getNextId() {
        List<Objeto> objetos = (List<Objeto>) objetoCrudRepository.findAll();
        int maxId = objetos.stream()
                .map(objeto -> Integer.parseInt(objeto.getId()))
                .max(Integer::compareTo)
                .orElse(0);
        return String.valueOf(maxId + 1);
    }
}

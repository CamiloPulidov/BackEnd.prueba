package com.producto.productoApi.web.controller;

import com.producto.productoApi.domain.dto.Object;
import com.producto.productoApi.domain.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/objetos")
public class ObjetoController {
    @Autowired
    ObjectService objectService;

    @GetMapping("/all")
    public List<Object> getAll() {
        return objectService.getAll();
    }

    @PostMapping("/save")
    public Object save(@RequestBody Object object) {
        if (object.getId() == null || object.getId().isEmpty()) {
            object.setId(objectService.getNextId()); // Genera un ID si no se proporciona
        }
        return objectService.save(object);
    }


    @DeleteMapping("/borrar/{borrar}")
    public void delete(@PathVariable("borrar") String borrar) {
        objectService.delete(borrar);
    }

    @PutMapping("/update/{id}")
    public Object update(@PathVariable("id") String id, @RequestBody Object object) {
        object.setId(id); // Asegúrate de que el ID sea correcto
        return objectService.save(object);
    }

    @GetMapping("/nextId")
    public String getNextId() {
        return objectService.getNextId();
    }

}

package com.example.demo.controller;

import com.example.demo.model.ProductoModel;
import com.example.demo.service.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<ProductoModel>> listar(){
        return productoServices.listar();
    }

    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> guardar(@RequestBody ProductoModel producto){
        return productoServices.guardar(producto);
    }

    @DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        return productoServices.eliminar(id);
    }

    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizar(@RequestBody ProductoModel producto){
        return productoServices.actualizar(producto);
    }

    @GetMapping(path = "/obtener/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ProductoModel> obtenerId(@PathVariable Long id){
        return productoServices.obtenerId(id);
    }

}

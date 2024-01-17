package com.example.demo.service;

import com.example.demo.model.ProductoModel;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository repository;

    public ResponseEntity<List<ProductoModel>> listar(){

        if(!repository.findAll().isEmpty())
            return new ResponseEntity<List<ProductoModel>>(repository.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<List<ProductoModel>>(new ArrayList<>(), HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Void> guardar(ProductoModel producto){
        if ( producto != null){
            repository.save(producto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> eliminar(Long id){
        if ( id != null){
            if( ! repository.findById(id).isEmpty()){
                repository.deleteById(id);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

        }else
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> actualizar(ProductoModel producto){

        if ( producto.getId() != null){

            if( ! repository.findById(producto.getId()).isEmpty()){
                repository.save(producto);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

        }else
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<ProductoModel> obtenerId(Long id){

        if ( id != null){
            return new ResponseEntity<ProductoModel> (repository.findById(id).orElse(null),HttpStatus.OK);
        }else
            return new ResponseEntity<ProductoModel>(new ProductoModel(), HttpStatus.NO_CONTENT);
    }
}

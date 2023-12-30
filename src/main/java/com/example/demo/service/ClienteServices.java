package com.example.demo.service;

import com.example.demo.model.ClienteModel;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;

    /*public ResponseEntity<ClienteModel> getData(String documentype, Integer document){

        //ClienteModel clienteModel = new ClienteModel();
        clienteModel.setDocumentType(documentype);
        clienteModel.setNumberDocument(document);

        //return new ResponseEntity<ClienteModel>(clienteModel, HttpStatus.OK);
        return ResponseEntity.ok(clienteModel);

    }*/

    public ResponseEntity<List<ClienteModel>> listar(){

        if(!repository.findAll().isEmpty())
            return new ResponseEntity<List<ClienteModel>>(repository.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<List<ClienteModel>>(new ArrayList<>(), HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Void> guardar(ClienteModel cliente){
        if ( cliente != null){
            repository.save(cliente);
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

    public ResponseEntity<Void> actualizar(ClienteModel cliente){

        if ( cliente.getId() != null){

            if( ! repository.findById(cliente.getId()).isEmpty()){
                repository.save(cliente);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

        }else
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<ClienteModel> obtenerId(Long id){

        if ( id != null){
            return new ResponseEntity<ClienteModel> (repository.findById(id).orElse(null),HttpStatus.OK);
        }else
            return new ResponseEntity<ClienteModel>(new ClienteModel(), HttpStatus.NO_CONTENT);
    }
}

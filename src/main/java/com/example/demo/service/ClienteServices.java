package com.example.demo.service;

import com.example.demo.model.ClienteModel;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return new ResponseEntity<List<ClienteModel>>(repository.findAll(), HttpStatus.OK);
    }

    public void guardar(ClienteModel cliente){
        repository.save(cliente);
    }

    public void eliminar(Long id){ repository.deleteById(id);}

    public void actualizar(ClienteModel cliente){
        repository.save(cliente);
    }

    public ClienteModel obtenerId(Long id){
        return repository.findById(id).orElse(null);
    }
}

package com.example.demo.controller;

import com.example.demo.model.ClienteModel;
import com.example.demo.service.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClienteController{

    @Autowired
    private ClienteServices clienteServices;

    /*@GetMapping(path = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ClienteModel> getData(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "document") Integer document){
        return clienteServices.getData(type, document);
    }*/

    @GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<ClienteModel>>listar(){
        return clienteServices.listar();
    }

    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> guardar(@RequestBody ClienteModel cliente){
        return clienteServices.guardar(cliente);
    }

    @DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        return clienteServices.eliminar(id);
    }

    @PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizar(@RequestBody ClienteModel cliente){
        return clienteServices.actualizar(cliente);
    }

    @GetMapping(path = "/obtener/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ClienteModel> obtenerId(@PathVariable Long id){
        return clienteServices.obtenerId(id);
    }
}

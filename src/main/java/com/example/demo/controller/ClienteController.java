package com.example.demo.controller;

import com.example.demo.model.ClienteModel;
import com.example.demo.service.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping(path = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ClienteModel> getData(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "document") Integer document){
       // return clienteServices.getData(type, document);
        return null;
    }

    @GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ClienteModel>listar(){
        return clienteServices.listar();
    }

    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody ClienteModel cliente){
        clienteServices.guardar(cliente);
    }

    @DeleteMapping(path = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@RequestParam(name ="id") Long id){
        clienteServices.eliminar(id);
    }

    @PostMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody ClienteModel cliente){
        clienteServices.actualizar(cliente);
    }

    @GetMapping(path = "/obtener")
    public @ResponseBody ClienteModel obtenerId(@RequestParam(name ="id") Long id){
        return clienteServices.obtenerId(id);
    }
}

package com.example.Profact.controller;

import com.example.Profact.entities.Services;
import com.example.Profact.service.ServicoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicesController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public List<Services> findAllServices() {
        return servicoService.findAllServices();
    }

    @GetMapping("/pendentes")
    public List<Services> findServicesPendents() {
        return servicoService.findServicesPendents();
    }

    @GetMapping("/cancelados")
    public List<Services> findServicesCanceled() {
        return servicoService.findServicesCanceled();
    }

    @PostMapping("/inserir")
    public Services addService( @RequestBody Services service) {
        return servicoService.addService(service);
    }

    @PutMapping("/alterar")
    public Services alterService( @RequestBody Services service) {
       return servicoService.alterService(service);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> canceled(@PathVariable("id") Long id ) {
        servicoService.serviceCanceled(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id ) {
        servicoService.removeService(id);
        return ResponseEntity.ok().build();
    }

}

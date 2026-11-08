package com.example.tp_etudiants.controller;

import com.example.tp_etudiants.dto.EtudiantRequest;
import com.example.tp_etudiants.dto.EtudiantResponse;
import com.example.tp_etudiants.service.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "*") // utile pour le front PHP/JS
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @GetMapping
    public List<EtudiantResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public EtudiantResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EtudiantResponse create(@Valid @RequestBody EtudiantRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public EtudiantResponse update(@PathVariable Long id, @Valid @RequestBody EtudiantRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

package com.example.Conjunto4.controller;

import com.example.Conjunto4.DTO.VisitanteDTO;
import com.example.Conjunto4.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitantes")
public class VisitanteController {
    @Autowired
    private VisitanteService visitanteService;

    @PostMapping
    public ResponseEntity<VisitanteDTO> create(@RequestBody VisitanteDTO dto) {
        return ResponseEntity.ok(visitanteService.saveVisitante(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitanteDTO> getById(@PathVariable Long id) {
        VisitanteDTO dto = visitanteService.getVisitanteById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<VisitanteDTO> getAll() {
        return visitanteService.getAllVisitantes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        visitanteService.deleteVisitante(id);
        return ResponseEntity.noContent().build();
    }
}

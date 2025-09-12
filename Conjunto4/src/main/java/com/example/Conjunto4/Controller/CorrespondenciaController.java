package com.example.Conjunto4.Controller;

import com.example.Conjunto4.DTO.CorrespondenciaDTO;
import com.example.Conjunto4.Service.CorrespondenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/correspondencias")
public class CorrespondenciaController {
    @Autowired
    private CorrespondenciaService correspondenciaService;

    @PostMapping
    public ResponseEntity<CorrespondenciaDTO> create(@RequestBody CorrespondenciaDTO dto) {
        return ResponseEntity.ok(correspondenciaService.saveCorrespondencia(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorrespondenciaDTO> getById(@PathVariable Long id) {
        CorrespondenciaDTO dto = correspondenciaService.getCorrespondenciaById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<CorrespondenciaDTO> getAll() {
        return correspondenciaService.getAllCorrespondencias();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        correspondenciaService.deleteCorrespondencia(id);
        return ResponseEntity.noContent().build();
    }
}

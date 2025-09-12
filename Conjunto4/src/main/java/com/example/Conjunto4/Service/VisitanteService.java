package com.example.Conjunto4.service;

import com.example.Conjunto4.DTO.VisitanteDTO;
import java.util.List;

public interface VisitanteService {
    VisitanteDTO saveVisitante(VisitanteDTO visitanteDTO);
    VisitanteDTO getVisitanteById(Long id);
    List<VisitanteDTO> getAllVisitantes();
    void deleteVisitante(Long id);
}

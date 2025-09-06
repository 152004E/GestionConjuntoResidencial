package com.miapp.service;

import com.miapp.dto.VisitanteDTO;
import java.util.List;

public interface VisitanteService {
    VisitanteDTO crear(VisitanteDTO visitanteDTO);
    List<VisitanteDTO> listarTodos();
    VisitanteDTO buscarPorId(Long id);
    VisitanteDTO actualizar(Long id, VisitanteDTO visitanteDTO);
    void eliminar(Long id);
}

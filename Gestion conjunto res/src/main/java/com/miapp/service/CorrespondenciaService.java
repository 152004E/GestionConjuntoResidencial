package com.miapp.service;

import com.miapp.dto.CorrespondenciaDTO;
import java.util.List;

public interface CorrespondenciaService {
    CorrespondenciaDTO crear(CorrespondenciaDTO correspondenciaDTO);
    List<CorrespondenciaDTO> listarTodos();
    CorrespondenciaDTO buscarPorId(Long id);
    CorrespondenciaDTO actualizar(Long id, CorrespondenciaDTO correspondenciaDTO);
    void eliminar(Long id);
}

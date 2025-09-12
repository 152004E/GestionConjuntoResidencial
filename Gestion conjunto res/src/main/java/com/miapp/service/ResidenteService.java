package com.miapp.service;

import com.miapp.dto.ResidenteDTO;
import java.util.List;

public interface ResidenteService {
    ResidenteDTO crear(ResidenteDTO residenteDTO);
    List<ResidenteDTO> listarTodos();
    ResidenteDTO buscarPorId(Long id);
    ResidenteDTO actualizar(Long id, ResidenteDTO residenteDTO);
    void eliminar(Long id);
}

package com.miapp.service;

import com.miapp.dto.ApartamentoDTO;
import java.util.List;

public interface ApartamentoService {
    ApartamentoDTO crear(ApartamentoDTO apartamentoDTO);
    List<ApartamentoDTO> listarTodos();
    ApartamentoDTO buscarPorId(Long id);
    ApartamentoDTO actualizar(Long id, ApartamentoDTO apartamentoDTO);
    void eliminar(Long id);
}

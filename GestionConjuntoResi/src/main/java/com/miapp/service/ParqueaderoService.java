package com.miapp.service;

import com.miapp.dto.ParqueaderoDTO;
import java.util.List;

public interface ParqueaderoService {
    ParqueaderoDTO crear(ParqueaderoDTO parqueaderoDTO);
    List<ParqueaderoDTO> listarTodos();
    ParqueaderoDTO buscarPorId(Long id);
    ParqueaderoDTO actualizar(Long id, ParqueaderoDTO parqueaderoDTO);
    void eliminar(Long id);
}

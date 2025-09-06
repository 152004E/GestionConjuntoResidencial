package com.miapp.service;

import com.miapp.dto.PropietarioDTO;
import java.util.List;

public interface PropietarioService {
    PropietarioDTO crear(PropietarioDTO propietarioDTO);
    List<PropietarioDTO> listarTodos();
    PropietarioDTO buscarPorId(Long id);
    PropietarioDTO actualizar(Long id, PropietarioDTO propietarioDTO);
    void eliminar(Long id);
}

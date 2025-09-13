package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuarioById(Long id);
    List<UsuarioDTO> getAllUsuarios();
    void deleteUsuario(Long id);
}
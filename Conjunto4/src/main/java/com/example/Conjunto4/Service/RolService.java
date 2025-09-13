package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.RolDTO;
import java.util.List;

public interface RolService {
    RolDTO saveRol(RolDTO rolDTO);
    RolDTO getRolById(Long id);
    List<RolDTO> getAllRoles();
    void deleteRol(Long id);
}
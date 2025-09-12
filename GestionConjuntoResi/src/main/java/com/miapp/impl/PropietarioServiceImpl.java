package com.miapp.impl;

import com.miapp.dto.PropietarioDTO;
import com.miapp.entity.Propietario;
import com.miapp.repository.PropietarioRepository;
import com.miapp.service.PropietarioService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropietarioServiceImpl implements PropietarioService {
    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public PropietarioDTO crear(PropietarioDTO dto) {
        Propietario propietario = toEntity(dto);
        propietario = propietarioRepository.save(propietario);
        return toDTO(propietario);
    }

    @Override
    public List<PropietarioDTO> listarTodos() {
        return propietarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public PropietarioDTO buscarPorId(Long id) {
        return propietarioRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public PropietarioDTO actualizar(Long id, PropietarioDTO dto) {
        Propietario propietario = propietarioRepository.findById(id).orElse(null);
        if (propietario == null) return null;
        propietario.setNombre(dto.getNombre());
        propietario.setApellido(dto.getApellido());
        propietario.setDocumento(dto.getDocumento());
        propietario.setTelefono(dto.getTelefono());
        propietario.setEmail(dto.getEmail());
        propietario = propietarioRepository.save(propietario);
        return toDTO(propietario);
    }

    @Override
    public void eliminar(Long id) {
        propietarioRepository.deleteById(id);
    }

    private PropietarioDTO toDTO(Propietario propietario) {
        PropietarioDTO dto = new PropietarioDTO();
        dto.setId(propietario.getId());
        dto.setNombre(propietario.getNombre());
        dto.setApellido(propietario.getApellido());
        dto.setDocumento(propietario.getDocumento());
        dto.setTelefono(propietario.getTelefono());
        dto.setEmail(propietario.getEmail());
        if (propietario.getApartamentos() != null) {
            dto.setApartamentosIds(propietario.getApartamentos().stream().map(a -> a.getId()).collect(Collectors.toList()));
        }
        return dto;
    }

    private Propietario toEntity(PropietarioDTO dto) {
        Propietario propietario = new Propietario();
        propietario.setId(dto.getId());
        propietario.setNombre(dto.getNombre());
        propietario.setApellido(dto.getApellido());
        propietario.setDocumento(dto.getDocumento());
        propietario.setTelefono(dto.getTelefono());
        propietario.setEmail(dto.getEmail());
        // No se asignan apartamentos aquí
        return propietario;
    }
}

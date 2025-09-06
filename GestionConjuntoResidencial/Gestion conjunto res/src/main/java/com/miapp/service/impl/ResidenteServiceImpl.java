package com.miapp.service.impl;

import com.miapp.dto.ResidenteDTO;
import com.miapp.entity.Apartamento;
import com.miapp.entity.Residente;
import com.miapp.repository.ApartamentoRepository;
import com.miapp.repository.ResidenteRepository;
import com.miapp.service.ResidenteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidenteServiceImpl implements ResidenteService {
    private final ResidenteRepository residenteRepository;
    private final ApartamentoRepository apartamentoRepository;

    public ResidenteServiceImpl(ResidenteRepository residenteRepository, ApartamentoRepository apartamentoRepository) {
        this.residenteRepository = residenteRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    @Override
    public ResidenteDTO crear(ResidenteDTO dto) {
        Residente residente = toEntity(dto);
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            residente.setApartamento(apartamento);
        }
        residente = residenteRepository.save(residente);
        return toDTO(residente);
    }

    @Override
    public List<ResidenteDTO> listarTodos() {
        return residenteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResidenteDTO buscarPorId(Long id) {
        return residenteRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public ResidenteDTO actualizar(Long id, ResidenteDTO dto) {
        Residente residente = residenteRepository.findById(id).orElse(null);
        if (residente == null) return null;
        residente.setNombre(dto.getNombre());
        residente.setApellido(dto.getApellido());
        residente.setDocumento(dto.getDocumento());
        residente.setTelefono(dto.getTelefono());
        residente.setEmail(dto.getEmail());
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            residente.setApartamento(apartamento);
        }
        residente = residenteRepository.save(residente);
        return toDTO(residente);
    }

    @Override
    public void eliminar(Long id) {
        residenteRepository.deleteById(id);
    }

    private ResidenteDTO toDTO(Residente residente) {
        ResidenteDTO dto = new ResidenteDTO();
        dto.setId(residente.getId());
        dto.setNombre(residente.getNombre());
        dto.setApellido(residente.getApellido());
        dto.setDocumento(residente.getDocumento());
        dto.setTelefono(residente.getTelefono());
        dto.setEmail(residente.getEmail());
        if (residente.getApartamento() != null) {
            dto.setApartamentoId(residente.getApartamento().getId());
        }
        return dto;
    }

    private Residente toEntity(ResidenteDTO dto) {
        Residente residente = new Residente();
        residente.setId(dto.getId());
        residente.setNombre(dto.getNombre());
        residente.setApellido(dto.getApellido());
        residente.setDocumento(dto.getDocumento());
        residente.setTelefono(dto.getTelefono());
        residente.setEmail(dto.getEmail());
        // No se asigna apartamento aquí
        return residente;
    }
}

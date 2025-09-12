package com.example.Conjunto4.impl;

import com.example.Conjunto4.DTO.CorrespondenciaDTO;
import com.example.Conjunto4.Entity.Correspondencia;
import com.example.Conjunto4.Entity.Apartamento;
import com.example.Conjunto4.repository.CorrespondenciaRepository;
import com.example.Conjunto4.repository.ApartamentoRepository;
import com.example.Conjunto4.service.CorrespondenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CorrespondenciaServiceImpl implements CorrespondenciaService {
    @Autowired
    private CorrespondenciaRepository correspondenciaRepository;
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Override
    public CorrespondenciaDTO saveCorrespondencia(CorrespondenciaDTO dto) {
        Correspondencia entity = new Correspondencia();
        entity.setDescripcion(dto.getDescripcion());
        entity.setFechaRecepcion(dto.getFechaRecepcion());
        entity.setEntregadoA(dto.getEntregadoA());
        if (dto.getApartamentoId() != null) {
            Optional<Apartamento> apt = apartamentoRepository.findById(dto.getApartamentoId());
            apt.ifPresent(entity::setApartamento);
        }
        Correspondencia saved = correspondenciaRepository.save(entity);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public CorrespondenciaDTO getCorrespondenciaById(Long id) {
        return correspondenciaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<CorrespondenciaDTO> getAllCorrespondencias() {
        return correspondenciaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCorrespondencia(Long id) {
        correspondenciaRepository.deleteById(id);
    }

    private CorrespondenciaDTO toDTO(Correspondencia entity) {
        Long apartamentoId = entity.getApartamento() != null ? entity.getApartamento().getId() : null;
        return new CorrespondenciaDTO(
                entity.getId(),
                entity.getDescripcion(),
                entity.getFechaRecepcion(),
                entity.getEntregadoA(),
                apartamentoId
        );
    }
}

package com.example.Conjunto4.impl;

import com.example.Conjunto4.DTO.VisitanteDTO;
import com.example.Conjunto4.Entity.Visitante;
import com.example.Conjunto4.Entity.Apartamento;
import com.example.Conjunto4.repository.VisitanteRepository;
import com.example.Conjunto4.repository.ApartamentoRepository;
import com.example.Conjunto4.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitanteServiceImpl implements VisitanteService {
    @Autowired
    private VisitanteRepository visitanteRepository;
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Override
    public VisitanteDTO saveVisitante(VisitanteDTO dto) {
        Visitante entity = new Visitante();
        entity.setNombre(dto.getNombre());
        entity.setDocumento(dto.getDocumento());
        entity.setMotivoVisita(dto.getMotivoVisita());
        entity.setFechaVisita(dto.getFechaVisita());
        if (dto.getApartamentoId() != null) {
            Optional<Apartamento> apt = apartamentoRepository.findById(dto.getApartamentoId());
            apt.ifPresent(entity::setApartamento);
        }
        Visitante saved = visitanteRepository.save(entity);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public VisitanteDTO getVisitanteById(Long id) {
        return visitanteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<VisitanteDTO> getAllVisitantes() {
        return visitanteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVisitante(Long id) {
        visitanteRepository.deleteById(id);
    }

    private VisitanteDTO toDTO(Visitante entity) {
        Long apartamentoId = entity.getApartamento() != null ? entity.getApartamento().getId() : null;
        return new VisitanteDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getDocumento(),
                entity.getMotivoVisita(),
                entity.getFechaVisita(),
                apartamentoId
        );
    }
}

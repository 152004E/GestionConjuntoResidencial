package com.miapp.service.impl;

import com.miapp.dto.VisitanteDTO;
import com.miapp.entity.Apartamento;
import com.miapp.entity.Visitante;
import com.miapp.repository.ApartamentoRepository;
import com.miapp.repository.VisitanteRepository;
import com.miapp.service.VisitanteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitanteServiceImpl implements VisitanteService {
    private final VisitanteRepository visitanteRepository;
    private final ApartamentoRepository apartamentoRepository;

    public VisitanteServiceImpl(VisitanteRepository visitanteRepository, ApartamentoRepository apartamentoRepository) {
        this.visitanteRepository = visitanteRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    @Override
    public VisitanteDTO crear(VisitanteDTO dto) {
        Visitante visitante = toEntity(dto);
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            visitante.setApartamento(apartamento);
        }
        visitante = visitanteRepository.save(visitante);
        return toDTO(visitante);
    }

    @Override
    public List<VisitanteDTO> listarTodos() {
        return visitanteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public VisitanteDTO buscarPorId(Long id) {
        return visitanteRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public VisitanteDTO actualizar(Long id, VisitanteDTO dto) {
        Visitante visitante = visitanteRepository.findById(id).orElse(null);
        if (visitante == null) return null;
        visitante.setNombre(dto.getNombre());
        visitante.setDocumento(dto.getDocumento());
        visitante.setMotivoVisita(dto.getMotivoVisita());
        visitante.setFechaVisita(dto.getFechaVisita());
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            visitante.setApartamento(apartamento);
        }
        visitante = visitanteRepository.save(visitante);
        return toDTO(visitante);
    }

    @Override
    public void eliminar(Long id) {
        visitanteRepository.deleteById(id);
    }

    private VisitanteDTO toDTO(Visitante visitante) {
        VisitanteDTO dto = new VisitanteDTO();
        dto.setId(visitante.getId());
        dto.setNombre(visitante.getNombre());
        dto.setDocumento(visitante.getDocumento());
        dto.setMotivoVisita(visitante.getMotivoVisita());
        dto.setFechaVisita(visitante.getFechaVisita());
        if (visitante.getApartamento() != null) {
            dto.setApartamentoId(visitante.getApartamento().getId());
        }
        return dto;
    }

    private Visitante toEntity(VisitanteDTO dto) {
        Visitante visitante = new Visitante();
        visitante.setId(dto.getId());
        visitante.setNombre(dto.getNombre());
        visitante.setDocumento(dto.getDocumento());
        visitante.setMotivoVisita(dto.getMotivoVisita());
        visitante.setFechaVisita(dto.getFechaVisita());
        // No se asigna apartamento aquí
        return visitante;
    }
}

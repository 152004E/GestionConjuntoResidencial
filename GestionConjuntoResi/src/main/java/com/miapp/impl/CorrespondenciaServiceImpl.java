package com.miapp.impl;

import com.miapp.dto.CorrespondenciaDTO;
import com.miapp.entity.Apartamento;
import com.miapp.entity.Correspondencia;
import com.miapp.repository.ApartamentoRepository;
import com.miapp.repository.CorrespondenciaRepository;
import com.miapp.service.CorrespondenciaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorrespondenciaServiceImpl implements CorrespondenciaService {
    private final CorrespondenciaRepository correspondenciaRepository;
    private final ApartamentoRepository apartamentoRepository;

    public CorrespondenciaServiceImpl(CorrespondenciaRepository correspondenciaRepository, ApartamentoRepository apartamentoRepository) {
        this.correspondenciaRepository = correspondenciaRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    @Override
    public CorrespondenciaDTO crear(CorrespondenciaDTO dto) {
        Correspondencia correspondencia = toEntity(dto);
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            correspondencia.setApartamento(apartamento);
        }
        correspondencia = correspondenciaRepository.save(correspondencia);
        return toDTO(correspondencia);
    }

    @Override
    public List<CorrespondenciaDTO> listarTodos() {
        return correspondenciaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CorrespondenciaDTO buscarPorId(Long id) {
        return correspondenciaRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public CorrespondenciaDTO actualizar(Long id, CorrespondenciaDTO dto) {
        Correspondencia correspondencia = correspondenciaRepository.findById(id).orElse(null);
        if (correspondencia == null) return null;
        correspondencia.setDescripcion(dto.getDescripcion());
        correspondencia.setFechaRecepcion(dto.getFechaRecepcion());
        correspondencia.setEntregadoA(dto.getEntregadoA());
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            correspondencia.setApartamento(apartamento);
        }
        correspondencia = correspondenciaRepository.save(correspondencia);
        return toDTO(correspondencia);
    }

    @Override
    public void eliminar(Long id) {
        correspondenciaRepository.deleteById(id);
    }

    private CorrespondenciaDTO toDTO(Correspondencia correspondencia) {
        CorrespondenciaDTO dto = new CorrespondenciaDTO();
        dto.setId(correspondencia.getId());
        dto.setDescripcion(correspondencia.getDescripcion());
        dto.setFechaRecepcion(correspondencia.getFechaRecepcion());
        dto.setEntregadoA(correspondencia.getEntregadoA());
        if (correspondencia.getApartamento() != null) {
            dto.setApartamentoId(correspondencia.getApartamento().getId());
        }
        return dto;
    }

    private Correspondencia toEntity(CorrespondenciaDTO dto) {
        Correspondencia correspondencia = new Correspondencia();
        correspondencia.setId(dto.getId());
        correspondencia.setDescripcion(dto.getDescripcion());
        correspondencia.setFechaRecepcion(dto.getFechaRecepcion());
        correspondencia.setEntregadoA(dto.getEntregadoA());
        // No se asigna apartamento aquí
        return correspondencia;
    }
}

package com.miapp.impl;

import com.miapp.dto.ParqueaderoDTO;
import com.miapp.entity.Apartamento;
import com.miapp.entity.Parqueadero;
import com.miapp.repository.ApartamentoRepository;
import com.miapp.repository.ParqueaderoRepository;
import com.miapp.service.ParqueaderoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {
    private final ParqueaderoRepository parqueaderoRepository;
    private final ApartamentoRepository apartamentoRepository;

    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository, ApartamentoRepository apartamentoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    @Override
    public ParqueaderoDTO crear(ParqueaderoDTO dto) {
        Parqueadero parqueadero = toEntity(dto);
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            parqueadero.setApartamento(apartamento);
        }
        parqueadero = parqueaderoRepository.save(parqueadero);
        return toDTO(parqueadero);
    }

    @Override
    public List<ParqueaderoDTO> listarTodos() {
        return parqueaderoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ParqueaderoDTO buscarPorId(Long id) {
        return parqueaderoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public ParqueaderoDTO actualizar(Long id, ParqueaderoDTO dto) {
        Parqueadero parqueadero = parqueaderoRepository.findById(id).orElse(null);
        if (parqueadero == null) return null;
        parqueadero.setNumero(dto.getNumero());
        parqueadero.setTipo(dto.getTipo());
        if (dto.getApartamentoId() != null) {
            Apartamento apartamento = apartamentoRepository.findById(dto.getApartamentoId()).orElse(null);
            parqueadero.setApartamento(apartamento);
        }
        parqueadero = parqueaderoRepository.save(parqueadero);
        return toDTO(parqueadero);
    }

    @Override
    public void eliminar(Long id) {
        parqueaderoRepository.deleteById(id);
    }

    private ParqueaderoDTO toDTO(Parqueadero parqueadero) {
        ParqueaderoDTO dto = new ParqueaderoDTO();
        dto.setId(parqueadero.getId());
        dto.setNumero(parqueadero.getNumero());
        dto.setTipo(parqueadero.getTipo());
        if (parqueadero.getApartamento() != null) {
            dto.setApartamentoId(parqueadero.getApartamento().getId());
        }
        return dto;
    }

    private Parqueadero toEntity(ParqueaderoDTO dto) {
        Parqueadero parqueadero = new Parqueadero();
        parqueadero.setId(dto.getId());
        parqueadero.setNumero(dto.getNumero());
        parqueadero.setTipo(dto.getTipo());
        // No se asigna apartamento aquí
        return parqueadero;
    }
}

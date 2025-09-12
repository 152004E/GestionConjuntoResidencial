package com.miapp.impl;

import com.miapp.dto.ApartamentoDTO;
import com.miapp.entity.Apartamento;
import com.miapp.entity.Propietario;
import com.miapp.repository.ApartamentoRepository;
import com.miapp.repository.PropietarioRepository;
import com.miapp.service.ApartamentoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartamentoServiceImpl implements ApartamentoService {
    private final ApartamentoRepository apartamentoRepository;
    private final PropietarioRepository propietarioRepository;

    public ApartamentoServiceImpl(ApartamentoRepository apartamentoRepository, PropietarioRepository propietarioRepository) {
        this.apartamentoRepository = apartamentoRepository;
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public ApartamentoDTO crear(ApartamentoDTO dto) {
        Apartamento apartamento = toEntity(dto);
        if (dto.getPropietarioId() != null) {
            Propietario propietario = propietarioRepository.findById(dto.getPropietarioId()).orElse(null);
            apartamento.setPropietario(propietario);
        }
        apartamento = apartamentoRepository.save(apartamento);
        return toDTO(apartamento);
    }

    @Override
    public List<ApartamentoDTO> listarTodos() {
        return apartamentoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ApartamentoDTO buscarPorId(Long id) {
        return apartamentoRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public ApartamentoDTO actualizar(Long id, ApartamentoDTO dto) {
        Apartamento apartamento = apartamentoRepository.findById(id).orElse(null);
        if (apartamento == null) return null;
        apartamento.setNumero(dto.getNumero());
        apartamento.setTorre(dto.getTorre());
        apartamento.setPiso(dto.getPiso());
        if (dto.getPropietarioId() != null) {
            Propietario propietario = propietarioRepository.findById(dto.getPropietarioId()).orElse(null);
            apartamento.setPropietario(propietario);
        }
        apartamento = apartamentoRepository.save(apartamento);
        return toDTO(apartamento);
    }

    @Override
    public void eliminar(Long id) {
        apartamentoRepository.deleteById(id);
    }

    private ApartamentoDTO toDTO(Apartamento apartamento) {
        ApartamentoDTO dto = new ApartamentoDTO();
        dto.setId(apartamento.getId());
        dto.setNumero(apartamento.getNumero());
        dto.setTorre(apartamento.getTorre());
        dto.setPiso(apartamento.getPiso());
        if (apartamento.getPropietario() != null) {
            dto.setPropietarioId(apartamento.getPropietario().getId());
        }
        // Relaciones con residentes, visitantes, parqueaderos y correspondencias pueden ser mapeadas aquí si es necesario
        return dto;
    }

    private Apartamento toEntity(ApartamentoDTO dto) {
        Apartamento apartamento = new Apartamento();
        apartamento.setId(dto.getId());
        apartamento.setNumero(dto.getNumero());
        apartamento.setTorre(dto.getTorre());
        apartamento.setPiso(dto.getPiso());
        // No se asignan listas aquí
        return apartamento;
    }
}

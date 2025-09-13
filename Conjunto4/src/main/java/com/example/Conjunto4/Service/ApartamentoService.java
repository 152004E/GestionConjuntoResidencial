package com.example.Conjunto4.Service;

import com.example.Conjunto4.Entity.Apartamento;
import com.example.Conjunto4.Repository.ApartamentoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de Apartamentos.
 */
@Service

public class ApartamentoService {
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    /**
     * Crear un nuevo apartamento.
     */
    public Apartamento crearApartamento(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    /**
     * Obtener todos los apartamentos.
     */
    public List<Apartamento> obtenerTodosLosApartamentos() {
        return apartamentoRepository.findAll();
    }

    /**
     * Obtener un apartamento por su ID.
     */
    public Optional<Apartamento> obtenerApartamentoPorId(Long id) {
        return apartamentoRepository.findById(id);
    }

    /**
     * Actualizar un apartamento existente.
     */
    public Apartamento actualizarApartamento(Long id, Apartamento apartamentoActualizado) {
        return apartamentoRepository.findById(id)
                .map(apartamento -> {
                    apartamento.setNumero(apartamentoActualizado.getNumero());

                    apartamento.setTorre(apartamentoActualizado.getTorre());
                    return apartamentoRepository.save(apartamento);
                })
                .orElse(null);
    }

    /**
     * Eliminar un apartamento por su ID.
     */
    public void eliminarApartamento(Long id) {
        apartamentoRepository.deleteById(id);
    }
}

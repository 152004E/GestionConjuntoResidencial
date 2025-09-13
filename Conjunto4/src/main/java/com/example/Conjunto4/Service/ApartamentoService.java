package com.example.Conjunto4.Service;

import com.example.Conjunto4.Entity.Apartamento;
import com.example.Conjunto4.Repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    // Mostrar todos los apartamentos
    public List<Apartamento> findAll() {
        return apartamentoRepository.findAll();
    }

    // Encontrar apartamento por ID
    public Optional<Apartamento> findById(Long idApartamento) {
        return apartamentoRepository.findById(idApartamento);
    }

    // Crear apartamento
    public Apartamento save(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    // Actualizar apartamento por ID
    public Apartamento update(Long idApartamento, Apartamento apartamentoDetails) {
        Optional<Apartamento> optionalApartamento = apartamentoRepository.findById(idApartamento);
        if (optionalApartamento.isPresent()) {
            Apartamento apartamento = optionalApartamento.get();
            apartamento.setNumero(apartamentoDetails.getNumero());
            apartamento.setTorre(apartamentoDetails.getTorre());
            apartamento.setPiso(apartamentoDetails.getPiso());
            apartamento.setVisitantes(apartamentoDetails.getVisitantes());
            apartamento.setParqueaderos(apartamentoDetails.getParqueaderos());
            apartamento.setCorrespondencias(apartamentoDetails.getCorrespondencias());
            return apartamentoRepository.save(apartamento);
        }
        return null;
    }

    // Borrar apartamento por ID
    public boolean delete(Long idApartamento) {
        if (apartamentoRepository.existsById(idApartamento)) {
            apartamentoRepository.deleteById(idApartamento);
            return true;
        }
        return false;
    }
}

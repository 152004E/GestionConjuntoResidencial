package com.example.Conjunto4.Service;

import com.example.Conjunto4.Entity.Torre;
import com.example.Conjunto4.Repository.TorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorreService {
    @Autowired
    private TorreRepository torreRepository;

    // Crear torre
    public Torre save(Torre torre) {
        return torreRepository.save(torre);
    }

    // Mostrar todas las torres
    public List<Torre> findAll() {
        return torreRepository.findAll();
    }

    // Encontrar torre por ID
    public Optional<Torre> findById(Long idTorre) {
        return torreRepository.findById(idTorre);
    }

    // Actualizar torre por ID
    public Torre update(Long idTorre, Torre detalles) {
        Optional<Torre> optionalTorre = torreRepository.findById(idTorre);
        if (optionalTorre.isPresent()) {
            Torre torre = optionalTorre.get();
            torre.setNombre(detalles.getNombre());
            torre.setApartamentos(detalles.getApartamentos());
            return torreRepository.save(torre);
        }
        return null;
    }

    // Borrar torre por ID
    public boolean delete(Long idTorre) {
        if (torreRepository.existsById(idTorre)) {
            torreRepository.deleteById(idTorre);
            return true;
        }
        return false;
    }
}

package com.example.Conjunto4.Service;

import com.example.Conjunto4.Entity.Torre;
import com.example.Conjunto4.Repository.TorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de Torres.
 */
@Service
public class TorreService {
    @Autowired
    private TorreRepository torreRepository;
    /**
     * Crear una nueva torre.
     */
    public Torre crearTorre(Torre torre) {
        return torreRepository.save(torre);
    }
    /**
     * Obtener todas las torres.
     */
    public List<Torre> obtenerTodasLasTorres() {
        return torreRepository.findAll();
    }
    /**
     * Obtener una torre por su ID.
     */
    public Optional<Torre> obtenerTorrePorId(Long id) {
        return torreRepository.findById(id);
    }
    /**
     * Actualizar una torre existente.
     */
    public Torre actualizarTorre(Long id, Torre torreActualizada) {
        return torreRepository.findById(id)
            .map(torre -> {
                torre.setNombre(torreActualizada.getNombre());
                torre.setNumeroDePisos(torreActualizada.getNumeroDePisos());
                return torreRepository.save(torre);
            })
            .orElse(null);
    }
    /**
     * Eliminar una torre por su ID.
     */
    public void eliminarTorre(Long id) {
        torreRepository.deleteById(id);
    }
}

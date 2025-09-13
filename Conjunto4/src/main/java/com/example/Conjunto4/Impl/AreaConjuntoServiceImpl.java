package com.example.Conjunto4.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Conjunto4.DTO.AreaConjuntoDTO;
import com.example.Conjunto4.Entity.AreaConjunto;
import com.example.Conjunto4.Repository.AreaConjuntoRepository;
import com.example.Conjunto4.Service.AreaConjuntoService;


/* Implementación de la interfaz AreaConjuntoService
 * Contiene la lógica de negocio para manejar las operaciones CRUD
*/
@Service
public class AreaConjuntoServiceImpl implements AreaConjuntoService {

    // Inyección del repositorio de AreaConjunto
    @Autowired
    private AreaConjuntoRepository areaConjuntoRepository;


    /* Método para convertir de entidad a DTO */
    private AreaConjuntoDTO toDTO (AreaConjunto entity) {
        return new AreaConjuntoDTO(
            entity.getId(),
            entity.getNombreArea(),
            entity.getDescripcion(),
            entity.getCapacidad(),
            entity.getTipoArea(),
            entity.getReservable()
        );
    }


    /* Método para convertir de DTO a entidad */
    private AreaConjunto toEntity (AreaConjuntoDTO dto) {
        return new AreaConjunto(
            dto.getId(),
            dto.getNombreArea(),
            dto.getDescripcion(),
            dto.getCapacidad(),
            dto.getTipoArea(),
            dto.getReservable()
        );
    }


    /* Métodos de la interfaz AreaConjuntoService */

    // Crear un nuevo AreaConjunto
    @Override
    public AreaConjuntoDTO crearArea(AreaConjuntoDTO areaDTO) {
        AreaConjunto area = toEntity(areaDTO);
        AreaConjunto guardado = areaConjuntoRepository.save(area);
        return toDTO(guardado);
    }

    // Obtener un AreaConjunto por su ID
    @Override
    public AreaConjuntoDTO obtenerAreaPorId(Long id) {
        Optional<AreaConjunto> area = areaConjuntoRepository.findById(id);
        return area.map(this::toDTO).orElse(null);
    }

    // Listar todas las AreaConjunto
    @Override
    public java.util.List<AreaConjuntoDTO> listarAreas() {
        return areaConjuntoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    // Actualizar un AreaConjunto existente
    @Override
    public AreaConjuntoDTO actualizarArea(Long id, AreaConjuntoDTO areaDTO) {
        Optional<AreaConjunto> existente = areaConjuntoRepository.findById(id);
        if (existente.isPresent()) {
            AreaConjunto area = existente.get();
            area.setNombreArea(areaDTO.getNombreArea());
            area.setDescripcion(areaDTO.getDescripcion());
            area.setCapacidad(areaDTO.getCapacidad());
            area.setTipoArea(areaDTO.getTipoArea());
            area.setReservable(areaDTO.getReservable());

            AreaConjunto actualizado = areaConjuntoRepository.save(area);
            return toDTO(actualizado);
        }else {
            return null; 
        }
    }

    // Eliminar un AreaConjunto por su ID
    @Override
    public void eliminarArea(Long id) {
        areaConjuntoRepository.deleteById(id);
    }
    
}

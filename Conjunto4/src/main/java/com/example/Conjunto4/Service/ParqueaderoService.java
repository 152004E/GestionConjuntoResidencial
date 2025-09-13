package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.ParqueaderoDTO;
import java.util.List;

public interface ParqueaderoService {
    ParqueaderoDTO saveParqueadero(ParqueaderoDTO parqueaderoDTO);
    ParqueaderoDTO getParqueaderoById(Long id);
    List<ParqueaderoDTO> getAllParqueaderos();
    void deleteParqueadero(Long id);
}

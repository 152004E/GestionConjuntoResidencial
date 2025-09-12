package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.CorrespondenciaDTO;
import java.util.List;

public interface CorrespondenciaService {
    CorrespondenciaDTO saveCorrespondencia(CorrespondenciaDTO correspondenciaDTO);
    CorrespondenciaDTO getCorrespondenciaById(Long id);
    List<CorrespondenciaDTO> getAllCorrespondencias();
    void deleteCorrespondencia(Long id);
}

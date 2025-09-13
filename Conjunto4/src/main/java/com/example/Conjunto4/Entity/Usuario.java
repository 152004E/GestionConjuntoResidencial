package com.example.Conjunto4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String email;
    private String contrasena;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
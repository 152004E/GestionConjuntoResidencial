package com.example.Conjunto4.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "torre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Torre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTorre")
    private Long idTorre;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "torre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Apartamento> apartamentos;
}

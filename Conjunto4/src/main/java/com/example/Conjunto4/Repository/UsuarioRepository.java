package com.example.Conjunto4.Repository;

import com.example.Conjunto4.Entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

}

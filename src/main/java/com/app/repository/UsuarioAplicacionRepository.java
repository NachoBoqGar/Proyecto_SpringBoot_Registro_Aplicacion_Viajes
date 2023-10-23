package com.app.repository;

import com.app.entities.UsuarioAplicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioAplicacionRepository extends CrudRepository<UsuarioAplicacion, Long> {

    Optional<UsuarioAplicacion> findByNombreusuario(String nombre);
    Optional<UsuarioAplicacion> findByEmail(String nombre);
}

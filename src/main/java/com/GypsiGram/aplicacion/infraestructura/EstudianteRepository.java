package com.GypsiGram.aplicacion.infraestructura;

import com.GypsiGram.aplicacion.dominio.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    @Query("SELECT e FROM Estudiante e WHERE e.email = :email AND e.contrasenia = :password")
    public Optional<Estudiante> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}

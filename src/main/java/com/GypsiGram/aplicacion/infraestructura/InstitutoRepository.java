package com.GypsiGram.aplicacion.infraestructura;

import com.GypsiGram.aplicacion.dominio.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

@Repository
public interface InstitutoRepository extends JpaRepository<Instituto, Long> {

    @Query("SELECT i FROM Instituto i WHERE i.email = :email AND i.contrasenia = :password")
    public Optional<Instituto> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}

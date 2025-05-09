package com.GypsiGram.aplicacion.infraestructura;

import com.GypsiGram.aplicacion.dominio.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutoRepository extends JpaRepository<Instituto, Long> {
}

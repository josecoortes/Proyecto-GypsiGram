package com.GypsiGram.aplicacion.infraestructura;

import com.GypsiGram.aplicacion.dominio.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}

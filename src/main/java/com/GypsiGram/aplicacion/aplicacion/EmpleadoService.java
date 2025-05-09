package com.GypsiGram.aplicacion.aplicacion;
import com.GypsiGram.aplicacion.dominio.Empleado;
import com.GypsiGram.aplicacion.infraestructura.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos los empleados
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    // Busca un empleado por su id
    public Empleado buscarEmpleadoPorId(Integer id) { 
        return empleadoRepository.findById(id).orElse(null);
    }

    // Crear un nuevo empleado
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}

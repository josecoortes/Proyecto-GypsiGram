package com.GypsiGram.aplicacion.aplicacion;

import com.GypsiGram.aplicacion.dominio.Empresa;
import com.GypsiGram.aplicacion.infraestructura.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Obtener todas las empresas
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    // Crear una nueva empresa
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Obtener un estudiante por ID
    public Empresa buscarEmpresaPorId(String id) {
        return empresaRepository.findById(id).orElse(null);
    }

    // Actualizar una Empresa
    public Empresa actualizarEmpresa(String id, Empresa datosEmpresa) {

        // Copiamos los datos a modificar en una nueva instancia de Empresa
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe la empresa"));

        // Si la tupla existe, modificamos los datos
        if (datosEmpresa.getContrasenia() != null) empresa.setContrasenia(datosEmpresa.getContrasenia());
        empresa.setDireccion(datosEmpresa.getDireccion());
        empresa.setLocalidad(datosEmpresa.getLocalidad());
        empresa.setNombre(datosEmpresa.getNombre());
        empresa.setNombreResponsable(datosEmpresa.getNombreResponsable());
        empresa.setApellido1Responsable(datosEmpresa.getApellido1Responsable());
        empresa.setApellido2Responsable(datosEmpresa.getApellido2Responsable());
        empresa.setProvincia(datosEmpresa.getProvincia());
        empresa.setDireccionSedePracticas(datosEmpresa.getDireccionSedePracticas());
        empresa.setTelefono(datosEmpresa.getTelefono());
        empresa.setEmail(datosEmpresa.getEmail());


        // Salvamos los cambios
        return empresaRepository.save(empresa);
    }

    // Eliminar una Empresa por ID
    public void eliminarEmpresa(String id) {
        empresaRepository.deleteById(id);
    }

}

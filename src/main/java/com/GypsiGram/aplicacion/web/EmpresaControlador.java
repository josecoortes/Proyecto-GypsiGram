package com.GypsiGram.aplicacion.web;

import com.GypsiGram.aplicacion.aplicacion.EmpresaService;
import com.GypsiGram.aplicacion.dominio.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin(origins = "*")
public class EmpresaControlador {

    @Autowired
    private EmpresaService empresaService;

    // Endpoint para obtener todas las empresas
    @GetMapping("/listar")
    public List<Empresa> obtenerEmpresas() {
        return empresaService.listarEmpresas();
    }

    // Endpoint para crear una nueva empresa
    @PostMapping("/crear")
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaService.crearEmpresa(empresa);
    }

    // Endpoint para buscar empresas por su ID
    @GetMapping("obtener/{id}")
    public Empresa obtenerEmpresa(@PathVariable String id) {
        return empresaService.buscarEmpresaPorId(id);
    }

    // Endpoint para actualizar estudiante existente
    @PutMapping("actualizar/{id}")
    public Empresa actualizarEmpresa(@PathVariable String id, @RequestBody Empresa empresa) {
        return empresaService.actualizarEmpresa(id, empresa);
    }

    // Endpoint para eliminar un estudiante existente
    @DeleteMapping("eliminar/{id}")
    public String eliminarEmpresa(@PathVariable String id) {

        String msg;

        if (empresaService.buscarEmpresaPorId(id) == null) {
            msg = "No existe la empresa";
        } else{
            empresaService.eliminarEmpresa(id);
            msg = "Empresa eliminada";
        }

        return msg;
    }

}

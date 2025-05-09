package com.GypsiGram.aplicacion.web;

import com.GypsiGram.aplicacion.dominio.Estudiante;
import com.GypsiGram.aplicacion.infraestructura.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @PostMapping("/loginEstudiante")
    public ResponseEntity<?> login(@RequestBody Estudiante loginRequest) {
        return estudianteRepository.findByEmailAndPassword(
                loginRequest.getEmail(),
                loginRequest.getContrasenia())
                .map(estudiante -> ResponseEntity.ok().body(estudiante))
                .orElse(ResponseEntity.badRequest().build());
    }
}

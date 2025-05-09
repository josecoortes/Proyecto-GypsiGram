package com.GypsiGram.aplicacion.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Idioma {
    @Id
    private String nombre;

    @OneToMany(mappedBy = "idioma")
    @JsonIgnore
    private Set<IdiomaEstudiante> idiomassEstudiantes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

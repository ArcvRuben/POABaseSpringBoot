package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String coordinacion;
    private String periodo;
    private String director;
    @JsonIgnore

    @OneToMany(mappedBy = "carrera")
    private List<UsuCarrera> usuCarreras;
    @JsonIgnore

    @OneToMany(mappedBy = "carrera")
    private List<Estrategia> estrategias;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCoordinacion() {
        return coordinacion;
    }
    public void setCoordinacion(String coordinacion) {
        this.coordinacion = coordinacion;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public List<UsuCarrera> getUsuCarreras() {
        return usuCarreras;
    }
    public void setUsuCarreras(List<UsuCarrera> usuCarreras) {
        this.usuCarreras = usuCarreras;
    }
    public List<Estrategia> getEstrategias() {
        return estrategias;
    }
    public void setEstrategias(List<Estrategia> estrategias) {
        this.estrategias = estrategias;
    }
}

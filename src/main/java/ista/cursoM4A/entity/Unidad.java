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
@Table(name = "unidad")
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String coordinacion;
    private String director;
    @JsonIgnore
    @OneToMany(mappedBy = "unidad")
    private List<UsuUnidad> usuUnidades;
    @JsonIgnore
    @OneToMany(mappedBy = "unidad")
    private List<Proyecto> proyectos;

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
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public List<UsuUnidad> getUsuUnidades() {
        return usuUnidades;
    }
    public void setUsuUnidades(List<UsuUnidad> usuUnidades) {
        this.usuUnidades = usuUnidades;
    }
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}

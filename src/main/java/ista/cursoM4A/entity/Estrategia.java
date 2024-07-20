package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estrategia")
public class Estrategia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    private Carrera carrera;
    
    @OneToMany(mappedBy = "estrategia")
    private List<ObjetivosOperativosCarrera> objetivosOperativosCarrera;

    @OneToMany(mappedBy = "estrategia")
    private List<EvaluacionEncabezadoCarrera> evaluacionEncabezadoCarrera;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<ObjetivosOperativosCarrera> getObjetivosOperativosCarrera() {
        return objetivosOperativosCarrera;
    }

    public void setObjetivosOperativosCarrera(List<ObjetivosOperativosCarrera> objetivosOperativosCarrera) {
        this.objetivosOperativosCarrera = objetivosOperativosCarrera;
    }

    public List<EvaluacionEncabezadoCarrera> getEvaluacionEncabezadoCarrera() {
        return evaluacionEncabezadoCarrera;
    }

    public void setEvaluacionEncabezadoCarrera(List<EvaluacionEncabezadoCarrera> evaluacionEncabezadoCarrera) {
        this.evaluacionEncabezadoCarrera = evaluacionEncabezadoCarrera;
    }
}

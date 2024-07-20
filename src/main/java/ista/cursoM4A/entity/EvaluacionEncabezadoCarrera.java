package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluacionencabezadocarrera")
public class EvaluacionEncabezadoCarrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @ManyToOne
    private Estrategia estrategia;

    @OneToMany(mappedBy = "evaluacionEncabezadoCarrera")
    private List<EvaluacionDetalleCarrera> evaluacionDetalleCarrera;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public List<EvaluacionDetalleCarrera> getEvaluacionDetalleCarrera() {
        return evaluacionDetalleCarrera;
    }

    public void setEvaluacionDetalleCarrera(List<EvaluacionDetalleCarrera> evaluacionDetalleCarrera) {
        this.evaluacionDetalleCarrera = evaluacionDetalleCarrera;
    }
}

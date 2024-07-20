package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "evaluacionencabezadounidad")
public class EvaluacionEncabezadoUnidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    private Proyecto proyecto;

    @OneToMany(mappedBy = "encabezado")
    private List<EvaluacionDetalleUnidad> detalles;

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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<EvaluacionDetalleUnidad> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<EvaluacionDetalleUnidad> detalles) {
        this.detalles = detalles;
    }
}

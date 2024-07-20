package ista.cursoM4A.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluaciondetallecarrera")
public class EvaluacionDetalleCarrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double costosFijos;
    private Integer docenteResponsable;
    private Integer ejecutado;
    private String observaciones;
    private String entregable;
    private String horasActuales;
    private String horasEstimadas;

    @ManyToOne
    private ActividadesCarrera actividadesCarrera;

    @ManyToOne
    private EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCostosFijos() {
        return costosFijos;
    }

    public void setCostosFijos(Double costosFijos) {
        this.costosFijos = costosFijos;
    }

    public Integer getDocenteResponsable() {
        return docenteResponsable;
    }

    public void setDocenteResponsable(Integer docenteResponsable) {
        this.docenteResponsable = docenteResponsable;
    }

    public Integer getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(Integer ejecutado) {
        this.ejecutado = ejecutado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEntregable() {
        return entregable;
    }

    public void setEntregable(String entregable) {
        this.entregable = entregable;
    }

    public String getHorasActuales() {
        return horasActuales;
    }

    public void setHorasActuales(String horasActuales) {
        this.horasActuales = horasActuales;
    }

    public String getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(String horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public ActividadesCarrera getActividadesCarrera() {
        return actividadesCarrera;
    }

    public void setActividadesCarrera(ActividadesCarrera actividadesCarrera) {
        this.actividadesCarrera = actividadesCarrera;
    }

    public EvaluacionEncabezadoCarrera getEvaluacionEncabezadoCarrera() {
        return evaluacionEncabezadoCarrera;
    }

    public void setEvaluacionEncabezadoCarrera(EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera) {
        this.evaluacionEncabezadoCarrera = evaluacionEncabezadoCarrera;
    }
}

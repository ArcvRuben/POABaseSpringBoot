package ista.cursoM4A.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluaciondetalleunidad")
public class EvaluacionDetalleUnidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double costosFijos;
    private Long docenteResponsable;
    private int ejecutado;
    private String observaciones;

    @Lob
    private byte[] entregable;

    private String horasActuales;
    private String horasEstimadas;

    @ManyToOne
    @JoinColumn(name = "idActividades", nullable = false)
    private ActividadesUnidad actividad;

    @ManyToOne
    @JoinColumn(name = "idEncabezado", nullable = false)
    private EvaluacionEncabezadoUnidad encabezado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCostosFijos() {
        return costosFijos;
    }

    public void setCostosFijos(double costosFijos) {
        this.costosFijos = costosFijos;
    }

    public Long getDocenteResponsable() {
        return docenteResponsable;
    }

    public void setDocenteResponsable(Long docenteResponsable) {
        this.docenteResponsable = docenteResponsable;
    }

    public int getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(int ejecutado) {
        this.ejecutado = ejecutado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getEntregable() {
        return entregable;
    }

    public void setEntregable(byte[] entregable) {
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

    public ActividadesUnidad getActividad() {
        return actividad;
    }

    public void setActividad(ActividadesUnidad actividad) {
        this.actividad = actividad;
    }

    public EvaluacionEncabezadoUnidad getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(EvaluacionEncabezadoUnidad encabezado) {
        this.encabezado = encabezado;
    }
}

package ista.cursoM4A.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "actividadesunidad")
public class ActividadesUnidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String responsable;

    @Temporal(TemporalType.DATE)
    private Date plazo;

    @Lob
    private byte[] entregable;

    private int meta;
    private Double recFinIsta;
    private Double recFinAutogestion;

    @ManyToOne
    @JoinColumn(name = "idObjetivo", nullable = false)
    private ObjetivosOperativosUnidad objetivoOperativo;

    @OneToMany(mappedBy = "actividad")
    private List<EvaluacionDetalleUnidad> evaluaciones;

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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getPlazo() {
        return plazo;
    }

    public void setPlazo(Date plazo) {
        this.plazo = plazo;
    }

    public byte[] getEntregable() {
        return entregable;
    }

    public void setEntregable(byte[] entregable) {
        this.entregable = entregable;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public Double getRecFinIsta() {
        return recFinIsta;
    }

    public void setRecFinIsta(Double recFinIsta) {
        this.recFinIsta = recFinIsta;
    }

    public Double getRecFinAutogestion() {
        return recFinAutogestion;
    }

    public void setRecFinAutogestion(Double recFinAutogestion) {
        this.recFinAutogestion = recFinAutogestion;
    }

    public ObjetivosOperativosUnidad getObjetivoOperativo() {
        return objetivoOperativo;
    }

    public void setObjetivoOperativo(ObjetivosOperativosUnidad objetivoOperativo) {
        this.objetivoOperativo = objetivoOperativo;
    }

    public List<EvaluacionDetalleUnidad> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionDetalleUnidad> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}

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
import jakarta.persistence.Table;

@Entity
@Table(name = "actividades_carrera")
public class ActividadesCarrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String responsable;
    private Date plazo;

    @Lob
    private byte[] entregable;

    private Integer meta;
    private Double recFinIeta;
    private Double recFinAutogestion;

    @ManyToOne
    private ObjetivosOperativosCarrera objetivoOperativoCarrera;

    @OneToMany(mappedBy = "actividadesCarrera")
    private List<EvaluacionDetalleCarrera> evaluacionDetalleCarrera;

    // Getters and Setters
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

    public Integer getMeta() {
        return meta;
    }

    public void setMeta(Integer meta) {
        this.meta = meta;
    }

    public Double getRecFinIeta() {
        return recFinIeta;
    }

    public void setRecFinIeta(Double recFinIeta) {
        this.recFinIeta = recFinIeta;
    }

    public Double getRecFinAutogestion() {
        return recFinAutogestion;
    }

    public void setRecFinAutogestion(Double recFinAutogestion) {
        this.recFinAutogestion = recFinAutogestion;
    }

    public ObjetivosOperativosCarrera getObjetivoOperativoCarrera() {
        return objetivoOperativoCarrera;
    }

    public void setObjetivoOperativoCarrera(ObjetivosOperativosCarrera objetivoOperativoCarrera) {
        this.objetivoOperativoCarrera = objetivoOperativoCarrera;
    }

    public List<EvaluacionDetalleCarrera> getEvaluacionDetalleCarrera() {
        return evaluacionDetalleCarrera;
    }

    public void setEvaluacionDetalleCarrera(List<EvaluacionDetalleCarrera> evaluacionDetalleCarrera) {
        this.evaluacionDetalleCarrera = evaluacionDetalleCarrera;
    }
}

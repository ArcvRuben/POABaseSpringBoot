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
@Table(name = "proyecto")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    private String objetivo_estrategico;
    private String Estrategia;

    @ManyToOne
    private Unidad unidad;

    @OneToMany(mappedBy = "proyecto")
    private List<EvaluacionEncabezadoUnidad> evaluacionEncabezadoUnidades;

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getObjetivo_estrategico() {
		return objetivo_estrategico;
	}

	public void setObjetivo_estrategico(String objetivo_estrategico) {
		this.objetivo_estrategico = objetivo_estrategico;
	}

	public String getEstrategia() {
		return Estrategia;
	}

	public void setEstrategia(String estrategia) {
		Estrategia = estrategia;
	}

	public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public List<EvaluacionEncabezadoUnidad> getEvaluacionEncabezadoUnidades() {
        return evaluacionEncabezadoUnidades;
    }

    public void setEvaluacionEncabezadoUnidades(List<EvaluacionEncabezadoUnidad> evaluacionEncabezadoUnidades) {
        this.evaluacionEncabezadoUnidades = evaluacionEncabezadoUnidades;
    }
}

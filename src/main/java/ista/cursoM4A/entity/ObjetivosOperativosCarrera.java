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
@Table(name = "objetivosoperativoscarrera")
public class ObjetivosOperativosCarrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    private Estrategia estrategia;

    @OneToMany(mappedBy = "objetivoOperativoCarrera")
    private List<ActividadesCarrera> actividadesCarrera;

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

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public List<ActividadesCarrera> getActividadesCarrera() {
        return actividadesCarrera;
    }

    public void setActividadesCarrera(List<ActividadesCarrera> actividadesCarrera) {
        this.actividadesCarrera = actividadesCarrera;
    }
}

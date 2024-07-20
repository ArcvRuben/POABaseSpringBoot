package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.ObjetivosOperativosUnidad;

public interface IObjetivosOperativosUnidadService {
    public List<ObjetivosOperativosUnidad> findAll();
    public ObjetivosOperativosUnidad save(ObjetivosOperativosUnidad objetivosOperativosUnidad);
    public ObjetivosOperativosUnidad findById(Long id);
    public void delete(Long id);
}

package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.ObjetivosOperativosCarrera;

public interface IObjetivosOperativosCarreraService {
    public List<ObjetivosOperativosCarrera> findAll();
    public ObjetivosOperativosCarrera save(ObjetivosOperativosCarrera objetivosOperativosCarrera);
    public ObjetivosOperativosCarrera findById(Long id);
    public void delete(Long id);
}

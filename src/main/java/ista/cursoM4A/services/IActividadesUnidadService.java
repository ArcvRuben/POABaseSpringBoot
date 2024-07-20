package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.ActividadesUnidad;

public interface IActividadesUnidadService {
    public List<ActividadesUnidad> findAll();
    public ActividadesUnidad save(ActividadesUnidad actividadesUnidad);
    public ActividadesUnidad findById(Long id);
    public void delete(Long id);
}

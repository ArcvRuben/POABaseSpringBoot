package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.ActividadesCarrera;

public interface IActividadesCarreraService {
    public List<ActividadesCarrera> findAll();
    public ActividadesCarrera save(ActividadesCarrera actividadesCarrera);
    public ActividadesCarrera findById(Long id);
    public void delete(Long id);
}

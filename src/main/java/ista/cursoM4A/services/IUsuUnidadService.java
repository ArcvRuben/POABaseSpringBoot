package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.UsuUnidad;

public interface IUsuUnidadService {
    public List<UsuUnidad> findAll();
    public UsuUnidad save(UsuUnidad usuUnidad);
    public UsuUnidad findById(Long id);
    public void delete(Long id);
}

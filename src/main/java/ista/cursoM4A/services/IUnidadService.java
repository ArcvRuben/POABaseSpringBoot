package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Unidad;

public interface IUnidadService {
    public List<Unidad> findAll();
    public Unidad save(Unidad unidad);
    public Unidad findById(Long id);
    public void delete(Long id);
}

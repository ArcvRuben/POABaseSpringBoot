package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Proyecto;

public interface IProyectoService {
    public List<Proyecto> findAll();
    public Proyecto save(Proyecto proyecto);
    public Proyecto findById(Long id);
    public void delete(Long id);
}

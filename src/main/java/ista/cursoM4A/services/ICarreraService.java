package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Carrera;

public interface ICarreraService {
    public List<Carrera> findAll();
    public Carrera save(Carrera carrera);
    public Carrera findById(Long id);
    public void delete(Long id);
}

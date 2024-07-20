package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Estrategia;

public interface IEstrategiaService {
    public List<Estrategia> findAll();
    public Estrategia save(Estrategia estrategia);
    public Estrategia findById(Long id);
    public void delete(Long id);
}

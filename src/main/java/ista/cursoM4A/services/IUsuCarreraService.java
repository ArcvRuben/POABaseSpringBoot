package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.UsuCarrera;

public interface IUsuCarreraService {
    public List<UsuCarrera> findAll();
    public UsuCarrera save(UsuCarrera usuCarrera);
    public UsuCarrera findById(Long id);
    public void delete(Long id);
}

package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.EvaluacionDetalleCarrera;

public interface IEvaluacionDetalleCarreraService {
    public List<EvaluacionDetalleCarrera> findAll();
    public EvaluacionDetalleCarrera save(EvaluacionDetalleCarrera evaluacionDetalleCarrera);
    public EvaluacionDetalleCarrera findById(Long id);
    public void delete(Long id);
}

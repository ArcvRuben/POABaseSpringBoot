package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.EvaluacionEncabezadoCarrera;

public interface IEvaluacionEncabezadoCarreraService {
    public List<EvaluacionEncabezadoCarrera> findAll();
    public EvaluacionEncabezadoCarrera save(EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera);
    public EvaluacionEncabezadoCarrera findById(Long id);
    public void delete(Long id);
}

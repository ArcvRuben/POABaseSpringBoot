package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.EvaluacionEncabezadoUnidad;

public interface IEvaluacionEncabezadoUnidadService {
    public List<EvaluacionEncabezadoUnidad> findAll();
    public EvaluacionEncabezadoUnidad save(EvaluacionEncabezadoUnidad evaluacionEncabezadoUnidad);
    public EvaluacionEncabezadoUnidad findById(Long id);
    public void delete(Long id);
}

package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.EvaluacionDetalleUnidad;

public interface IEvaluacionDetalleUnidadService {
    public List<EvaluacionDetalleUnidad> findAll();
    public EvaluacionDetalleUnidad save(EvaluacionDetalleUnidad evaluacionDetalleUnidad);
    public EvaluacionDetalleUnidad findById(Long id);
    public void delete(Long id);
}

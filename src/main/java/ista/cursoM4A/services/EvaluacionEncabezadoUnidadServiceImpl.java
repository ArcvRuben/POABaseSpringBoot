package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IEvaluacionEncabezadoUnidadDao;
import ista.cursoM4A.entity.EvaluacionEncabezadoUnidad;

@Service
public class EvaluacionEncabezadoUnidadServiceImpl implements IEvaluacionEncabezadoUnidadService {

    @Autowired
    private IEvaluacionEncabezadoUnidadDao evaluacionEncabezadoUnidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionEncabezadoUnidad> findAll() {
        return (List<EvaluacionEncabezadoUnidad>) evaluacionEncabezadoUnidadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public EvaluacionEncabezadoUnidad findById(Long id) {
        return evaluacionEncabezadoUnidadDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public EvaluacionEncabezadoUnidad save(EvaluacionEncabezadoUnidad evaluacionEncabezadoUnidad) {
        return evaluacionEncabezadoUnidadDao.save(evaluacionEncabezadoUnidad);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        evaluacionEncabezadoUnidadDao.deleteById(id);
    }
}

package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IEvaluacionDetalleUnidadDao;
import ista.cursoM4A.entity.EvaluacionDetalleUnidad;

@Service
public class EvaluacionDetalleUnidadServiceImpl implements IEvaluacionDetalleUnidadService {

    @Autowired
    private IEvaluacionDetalleUnidadDao evaluacionDetalleUnidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionDetalleUnidad> findAll() {
        return (List<EvaluacionDetalleUnidad>) evaluacionDetalleUnidadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public EvaluacionDetalleUnidad findById(Long id) {
        return evaluacionDetalleUnidadDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public EvaluacionDetalleUnidad save(EvaluacionDetalleUnidad evaluacionDetalleUnidad) {
        return evaluacionDetalleUnidadDao.save(evaluacionDetalleUnidad);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        evaluacionDetalleUnidadDao.deleteById(id);
    }
}

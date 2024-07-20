package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IEvaluacionDetalleCarreraDao;
import ista.cursoM4A.entity.EvaluacionDetalleCarrera;

@Service
public class EvaluacionDetalleCarreraServiceImpl implements IEvaluacionDetalleCarreraService {

    @Autowired
    private IEvaluacionDetalleCarreraDao evaluacionDetalleCarreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionDetalleCarrera> findAll() {
        return (List<EvaluacionDetalleCarrera>) evaluacionDetalleCarreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public EvaluacionDetalleCarrera findById(Long id) {
        return evaluacionDetalleCarreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public EvaluacionDetalleCarrera save(EvaluacionDetalleCarrera evaluacionDetalleCarrera) {
        return evaluacionDetalleCarreraDao.save(evaluacionDetalleCarrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        evaluacionDetalleCarreraDao.deleteById(id);
    }
}

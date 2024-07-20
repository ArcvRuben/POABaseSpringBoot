package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IEvaluacionEncabezadoCarreraDao;
import ista.cursoM4A.entity.EvaluacionEncabezadoCarrera;

@Service
public class EvaluacionEncabezadoCarreraServiceImpl implements IEvaluacionEncabezadoCarreraService {

    @Autowired
    private IEvaluacionEncabezadoCarreraDao evaluacionEncabezadoCarreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionEncabezadoCarrera> findAll() {
        return (List<EvaluacionEncabezadoCarrera>) evaluacionEncabezadoCarreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public EvaluacionEncabezadoCarrera findById(Long id) {
        return evaluacionEncabezadoCarreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public EvaluacionEncabezadoCarrera save(EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera) {
        return evaluacionEncabezadoCarreraDao.save(evaluacionEncabezadoCarrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        evaluacionEncabezadoCarreraDao.deleteById(id);
    }
}

package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.ICarreraDao;
import ista.cursoM4A.entity.Carrera;

@Service
public class CarreraServiceImpl implements ICarreraService {

    @Autowired
    private ICarreraDao carreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Carrera> findAll() {
        return (List<Carrera>) carreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Long id) {
        return carreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraDao.save(carrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        carreraDao.deleteById(id);
    }
}

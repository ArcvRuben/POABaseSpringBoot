package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IObjetivosOperativosCarreraDao;
import ista.cursoM4A.entity.ObjetivosOperativosCarrera;

@Service
public class ObjetivosOperativosCarreraServiceImpl implements IObjetivosOperativosCarreraService {

    @Autowired
    private IObjetivosOperativosCarreraDao objetivosOperativosCarreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<ObjetivosOperativosCarrera> findAll() {
        return (List<ObjetivosOperativosCarrera>) objetivosOperativosCarreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public ObjetivosOperativosCarrera findById(Long id) {
        return objetivosOperativosCarreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public ObjetivosOperativosCarrera save(ObjetivosOperativosCarrera objetivosOperativosCarrera) {
        return objetivosOperativosCarreraDao.save(objetivosOperativosCarrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        objetivosOperativosCarreraDao.deleteById(id);
    }
}

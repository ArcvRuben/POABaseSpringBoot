package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IActividadesCarreraDao;
import ista.cursoM4A.entity.ActividadesCarrera;

@Service
public class ActividadesCarreraServiceImpl implements IActividadesCarreraService {

    @Autowired
    private IActividadesCarreraDao actividadesCarreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<ActividadesCarrera> findAll() {
        return (List<ActividadesCarrera>) actividadesCarreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public ActividadesCarrera findById(Long id) {
        return actividadesCarreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public ActividadesCarrera save(ActividadesCarrera actividadesCarrera) {
        return actividadesCarreraDao.save(actividadesCarrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        actividadesCarreraDao.deleteById(id);
    }
}

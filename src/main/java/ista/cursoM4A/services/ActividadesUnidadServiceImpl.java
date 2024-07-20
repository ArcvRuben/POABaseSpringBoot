package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IActividadesUnidadDao;
import ista.cursoM4A.entity.ActividadesUnidad;

@Service
public class ActividadesUnidadServiceImpl implements IActividadesUnidadService {

    @Autowired
    private IActividadesUnidadDao actividadesUnidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<ActividadesUnidad> findAll() {
        return (List<ActividadesUnidad>) actividadesUnidadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public ActividadesUnidad findById(Long id) {
        return actividadesUnidadDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public ActividadesUnidad save(ActividadesUnidad actividadesUnidad) {
        return actividadesUnidadDao.save(actividadesUnidad);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        actividadesUnidadDao.deleteById(id);
    }
}

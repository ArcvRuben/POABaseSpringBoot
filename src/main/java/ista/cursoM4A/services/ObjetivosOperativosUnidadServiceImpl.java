package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IObjetivosOperativosUnidadDao;
import ista.cursoM4A.entity.ObjetivosOperativosUnidad;

@Service
public class ObjetivosOperativosUnidadServiceImpl implements IObjetivosOperativosUnidadService {

    @Autowired
    private IObjetivosOperativosUnidadDao objetivosOperativosUnidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<ObjetivosOperativosUnidad> findAll() {
        return (List<ObjetivosOperativosUnidad>) objetivosOperativosUnidadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public ObjetivosOperativosUnidad findById(Long id) {
        return objetivosOperativosUnidadDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public ObjetivosOperativosUnidad save(ObjetivosOperativosUnidad objetivosOperativosUnidad) {
        return objetivosOperativosUnidadDao.save(objetivosOperativosUnidad);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        objetivosOperativosUnidadDao.deleteById(id);
    }
}

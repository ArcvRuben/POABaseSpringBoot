package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IUsuUnidadDao;
import ista.cursoM4A.entity.UsuUnidad;

@Service
public class UsuUnidadServiceImpl implements IUsuUnidadService {

    @Autowired
    private IUsuUnidadDao usuUnidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<UsuUnidad> findAll() {
        return (List<UsuUnidad>) usuUnidadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public UsuUnidad findById(Long id) {
        return usuUnidadDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public UsuUnidad save(UsuUnidad usuUnidad) {
        return usuUnidadDao.save(usuUnidad);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        usuUnidadDao.deleteById(id);
    }
}

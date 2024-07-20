package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IUsuCarreraDao;
import ista.cursoM4A.entity.UsuCarrera;

@Service
public class UsuCarreraServiceImpl implements IUsuCarreraService {

    @Autowired
    private IUsuCarreraDao usuCarreraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<UsuCarrera> findAll() {
        return (List<UsuCarrera>) usuCarreraDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public UsuCarrera findById(Long id) {
        return usuCarreraDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public UsuCarrera save(UsuCarrera usuCarrera) {
        return usuCarreraDao.save(usuCarrera);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        usuCarreraDao.deleteById(id);
    }
}

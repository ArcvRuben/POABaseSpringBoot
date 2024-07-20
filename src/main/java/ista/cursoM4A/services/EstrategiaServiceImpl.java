package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IEstrategiaDao;
import ista.cursoM4A.entity.Estrategia;

@Service
public class EstrategiaServiceImpl implements IEstrategiaService {

    @Autowired
    private IEstrategiaDao estrategiaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estrategia> findAll() {
        return (List<Estrategia>) estrategiaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estrategia findById(Long id) {
        return estrategiaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Estrategia save(Estrategia estrategia) {
        return estrategiaDao.save(estrategia);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        estrategiaDao.deleteById(id);
    }
}

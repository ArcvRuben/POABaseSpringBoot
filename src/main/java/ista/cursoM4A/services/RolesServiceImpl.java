package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IRolesDao;
import ista.cursoM4A.entity.Roles;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private IRolesDao rolesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Roles> findAll() {
        return (List<Roles>) rolesDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Roles findById(Long id) {
        return rolesDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Roles save(Roles roles) {
        return rolesDao.save(roles);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        rolesDao.deleteById(id);
    }
}

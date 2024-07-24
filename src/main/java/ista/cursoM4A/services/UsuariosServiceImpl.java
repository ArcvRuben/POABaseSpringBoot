package ista.cursoM4A.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM4A.dao.IUsuariosDao;
import ista.cursoM4A.entity.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    private IUsuariosDao usuariosDao;
    
    
    @Override
    public Usuarios findByCorreoAndContrasena(String correo, String contrasena) {
        return usuariosDao.findByCorreoAndContrasena(correo, contrasena);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return (List<Usuarios>) usuariosDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuarios findById(Long id) {
        return usuariosDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Usuarios save(Usuarios usuarios) {
        return usuariosDao.save(usuarios);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        usuariosDao.deleteById(id);
    }
}

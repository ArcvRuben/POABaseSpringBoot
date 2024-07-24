package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Usuarios;

public interface IUsuariosService {
    public List<Usuarios> findAll();
    public Usuarios save(Usuarios usuarios);
    public Usuarios findById(Long id);
    public void delete(Long id);
    // Método para autenticar usuario por email y contraseña
    Usuarios findByCorreoAndContrasena(String correo, String contrasena);

}

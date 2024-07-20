package ista.cursoM4A.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.cursoM4A.entity.Usuarios;
import ista.cursoM4A.services.IUsuariosService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuariosRestController {

    @Autowired
    private IUsuariosService usuariosService;

    @GetMapping("/usuarios")
    public List<Usuarios> index() {
        return usuariosService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuarios show(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios create(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios update(@RequestBody Usuarios usuarios, @PathVariable Long id) {
        Usuarios usuariosActual = usuariosService.findById(id);
        usuariosActual.setUsuario(usuarios.getUsuario());
        usuariosActual.setContrasena(usuarios.getContrasena());
        usuariosActual.setNombre(usuarios.getNombre());
        usuariosActual.setApellido(usuarios.getApellido());
        usuariosActual.setCorreo(usuarios.getCorreo());
        return usuariosService.save(usuariosActual);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuariosService.delete(id);
    }
}

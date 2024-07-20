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

import ista.cursoM4A.entity.UsuCarrera;
import ista.cursoM4A.services.IUsuCarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuCarreraRestController {

    @Autowired
    private IUsuCarreraService usuCarreraService;

    @GetMapping("/usuCarrera")
    public List<UsuCarrera> index() {
        return usuCarreraService.findAll();
    }

    @GetMapping("/usuCarrera/{id}")
    public UsuCarrera show(@PathVariable Long id) {
        return usuCarreraService.findById(id);
    }

    @PostMapping("/usuCarrera")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuCarrera create(@RequestBody UsuCarrera usuCarrera) {
        return usuCarreraService.save(usuCarrera);
    }

    @PutMapping("/usuCarrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuCarrera update(@RequestBody UsuCarrera usuCarrera, @PathVariable Long id) {
        UsuCarrera usuCarreraActual = usuCarreraService.findById(id);
        usuCarreraActual.setFecha(usuCarrera.getFecha());
        return usuCarreraService.save(usuCarreraActual);
    }

    @DeleteMapping("/usuCarrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuCarreraService.delete(id);
    }
}

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

import ista.cursoM4A.entity.UsuUnidad;
import ista.cursoM4A.services.IUsuUnidadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuUnidadRestController {

    @Autowired
    private IUsuUnidadService usuUnidadService;

    @GetMapping("/usuUnidad")
    public List<UsuUnidad> index() {
        return usuUnidadService.findAll();
    }

    @GetMapping("/usuUnidad/{id}")
    public UsuUnidad show(@PathVariable Long id) {
        return usuUnidadService.findById(id);
    }

    @PostMapping("/usuUnidad")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuUnidad create(@RequestBody UsuUnidad usuUnidad) {
        return usuUnidadService.save(usuUnidad);
    }

    @PutMapping("/usuUnidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuUnidad update(@RequestBody UsuUnidad usuUnidad, @PathVariable Long id) {
        UsuUnidad usuUnidadActual = usuUnidadService.findById(id);
        usuUnidadActual.setFecha(usuUnidad.getFecha());
        return usuUnidadService.save(usuUnidadActual);
    }

    @DeleteMapping("/usuUnidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuUnidadService.delete(id);
    }
}

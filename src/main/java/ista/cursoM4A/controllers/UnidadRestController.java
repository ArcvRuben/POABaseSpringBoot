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

import ista.cursoM4A.entity.Unidad;
import ista.cursoM4A.services.IUnidadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UnidadRestController {

    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/unidad")
    public List<Unidad> index() {
        return unidadService.findAll();
    }

    @GetMapping("/unidad/{id}")
    public Unidad show(@PathVariable Long id) {
        return unidadService.findById(id);
    }

    @PostMapping("/unidad")
    @ResponseStatus(HttpStatus.CREATED)
    public Unidad create(@RequestBody Unidad unidad) {
        return unidadService.save(unidad);
    }

    @PutMapping("/unidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Unidad update(@RequestBody Unidad unidad, @PathVariable Long id) {
        Unidad unidadActual = unidadService.findById(id);
        unidadActual.setNombre(unidad.getNombre());
        unidadActual.setCoordinacion(unidad.getCoordinacion());
        unidadActual.setDirector(unidad.getDirector());
        return unidadService.save(unidadActual);
    }

    @DeleteMapping("/unidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        unidadService.delete(id);
    }
}

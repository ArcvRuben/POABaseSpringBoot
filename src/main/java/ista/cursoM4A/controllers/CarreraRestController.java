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

import ista.cursoM4A.entity.Carrera;
import ista.cursoM4A.services.ICarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CarreraRestController {

    @Autowired
    private ICarreraService carreraService;

    @GetMapping("/carreras")
    public List<Carrera> index() {
        return carreraService.findAll();
    }

    @GetMapping("/carreras/{id}")
    public Carrera show(@PathVariable Long id) {
        return carreraService.findById(id);
    }

    @PostMapping("/carreras")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera create(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/carreras/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera update(@RequestBody Carrera carrera, @PathVariable Long id) {
        Carrera carreraActual = carreraService.findById(id);
        carreraActual.setNombre(carrera.getNombre());
        carreraActual.setCoordinacion(carrera.getCoordinacion());
        carreraActual.setPeriodo(carrera.getPeriodo());
        carreraActual.setDirector(carrera.getDirector());
        return carreraService.save(carreraActual);
    }

    @DeleteMapping("/carreras/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carreraService.delete(id);
    }
}

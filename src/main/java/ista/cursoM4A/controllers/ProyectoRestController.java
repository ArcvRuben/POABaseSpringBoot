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

import ista.cursoM4A.entity.Proyecto;
import ista.cursoM4A.services.IProyectoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProyectoRestController {

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/proyecto")
    public List<Proyecto> index() {
        return proyectoService.findAll();
    }

    @GetMapping("/proyecto/{id}")
    public Proyecto show(@PathVariable Long id) {
        return proyectoService.findById(id);
    }

    @PostMapping("/proyecto")
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto create(@RequestBody Proyecto proyecto) {
        return proyectoService.save(proyecto);
    }

    @PutMapping("/proyecto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto update(@RequestBody Proyecto proyecto, @PathVariable Long id) {
        Proyecto proyectoActual = proyectoService.findById(id);
        proyectoActual.setObjetivo_estrategico(proyecto.getObjetivo_estrategico());
        proyectoActual.setEstrategia(proyecto.getEstrategia());
        return proyectoService.save(proyectoActual);
    }

    @DeleteMapping("/proyecto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        proyectoService.delete(id);
    }
}

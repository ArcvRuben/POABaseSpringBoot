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

import ista.cursoM4A.entity.ObjetivosOperativosUnidad;
import ista.cursoM4A.entity.Proyecto;
import ista.cursoM4A.services.IObjetivosOperativosUnidadService;
import ista.cursoM4A.services.IProyectoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ObjetivosOperativosUnidadRestController {

    @Autowired
    private IObjetivosOperativosUnidadService objetivosOperativosUnidadService;

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/objetivosOperativosUnidad")
    public List<ObjetivosOperativosUnidad> index() {
        return objetivosOperativosUnidadService.findAll();
    }

    @GetMapping("/objetivosOperativosUnidad/{id}")
    public ObjetivosOperativosUnidad show(@PathVariable Long id) {
        return objetivosOperativosUnidadService.findById(id);
    }

    @PostMapping("/objetivosOperativosUnidad")
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivosOperativosUnidad create(@RequestBody ObjetivosOperativosUnidad objetivosOperativosUnidad) {
        Proyecto proyecto = objetivosOperativosUnidad.getProyecto();
        if (proyecto == null || proyecto.getIdProyecto() == null) {
            throw new IllegalArgumentException("El proyecto o su id no pueden ser nulos.");
        }

        Proyecto proyectoExistente = proyectoService.findById(proyecto.getIdProyecto());
        if (proyectoExistente == null) {
            throw new IllegalArgumentException("Proyecto no encontrado");
        }

        objetivosOperativosUnidad.setProyecto(proyectoExistente);
        return objetivosOperativosUnidadService.save(objetivosOperativosUnidad);
    }

    @PutMapping("/objetivosOperativosUnidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivosOperativosUnidad update(@RequestBody ObjetivosOperativosUnidad objetivosOperativosUnidad, @PathVariable Long id) {
        ObjetivosOperativosUnidad objetivosOperativosUnidadActual = objetivosOperativosUnidadService.findById(id);
        if (objetivosOperativosUnidadActual == null) {
            throw new IllegalArgumentException("Objetivo Operativo no encontrado");
        }
        
        objetivosOperativosUnidadActual.setDescripcion(objetivosOperativosUnidad.getDescripcion());
        return objetivosOperativosUnidadService.save(objetivosOperativosUnidadActual);
    }

    @DeleteMapping("/objetivosOperativosUnidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        objetivosOperativosUnidadService.delete(id);
    }
}

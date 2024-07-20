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

import ista.cursoM4A.entity.EvaluacionEncabezadoUnidad;
import ista.cursoM4A.services.IEvaluacionEncabezadoUnidadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EvaluacionEncabezadoUnidadRestController {

    @Autowired
    private IEvaluacionEncabezadoUnidadService evaluacionEncabezadoUnidadService;

    @GetMapping("/evaluacionEncabezadoUnidad")
    public List<EvaluacionEncabezadoUnidad> index() {
        return evaluacionEncabezadoUnidadService.findAll();
    }

    @GetMapping("/evaluacionEncabezadoUnidad/{id}")
    public EvaluacionEncabezadoUnidad show(@PathVariable Long id) {
        return evaluacionEncabezadoUnidadService.findById(id);
    }

    @PostMapping("/evaluacionEncabezadoUnidad")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionEncabezadoUnidad create(@RequestBody EvaluacionEncabezadoUnidad evaluacionEncabezadoUnidad) {
        return evaluacionEncabezadoUnidadService.save(evaluacionEncabezadoUnidad);
    }

    @PutMapping("/evaluacionEncabezadoUnidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionEncabezadoUnidad update(@RequestBody EvaluacionEncabezadoUnidad evaluacionEncabezadoUnidad, @PathVariable Long id) {
        EvaluacionEncabezadoUnidad evaluacionEncabezadoUnidadActual = evaluacionEncabezadoUnidadService.findById(id);
        evaluacionEncabezadoUnidadActual.setFecha(evaluacionEncabezadoUnidad.getFecha());
        return evaluacionEncabezadoUnidadService.save(evaluacionEncabezadoUnidadActual);
    }

    @DeleteMapping("/evaluacionEncabezadoUnidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        evaluacionEncabezadoUnidadService.delete(id);
    }
}

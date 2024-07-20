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

import ista.cursoM4A.entity.EvaluacionDetalleUnidad;
import ista.cursoM4A.services.IEvaluacionDetalleUnidadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EvaluacionDetalleUnidadRestController {

    @Autowired
    private IEvaluacionDetalleUnidadService evaluacionDetalleUnidadService;

    @GetMapping("/evaluacionDetalleUnidad")
    public List<EvaluacionDetalleUnidad> index() {
        return evaluacionDetalleUnidadService.findAll();
    }

    @GetMapping("/evaluacionDetalleUnidad/{id}")
    public EvaluacionDetalleUnidad show(@PathVariable Long id) {
        return evaluacionDetalleUnidadService.findById(id);
    }

    @PostMapping("/evaluacionDetalleUnidad")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionDetalleUnidad create(@RequestBody EvaluacionDetalleUnidad evaluacionDetalleUnidad) {
        return evaluacionDetalleUnidadService.save(evaluacionDetalleUnidad);
    }

    @PutMapping("/evaluacionDetalleUnidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionDetalleUnidad update(@RequestBody EvaluacionDetalleUnidad evaluacionDetalleUnidad, @PathVariable Long id) {
        EvaluacionDetalleUnidad evaluacionDetalleUnidadActual = evaluacionDetalleUnidadService.findById(id);
        evaluacionDetalleUnidadActual.setCostosFijos(evaluacionDetalleUnidad.getCostosFijos());
        evaluacionDetalleUnidadActual.setDocenteResponsable(evaluacionDetalleUnidad.getDocenteResponsable());
        evaluacionDetalleUnidadActual.setEjecutado(evaluacionDetalleUnidad.getEjecutado());
        evaluacionDetalleUnidadActual.setObservaciones(evaluacionDetalleUnidad.getObservaciones());
        evaluacionDetalleUnidadActual.setEntregable(evaluacionDetalleUnidad.getEntregable());
        evaluacionDetalleUnidadActual.setHorasActuales(evaluacionDetalleUnidad.getHorasActuales());
        evaluacionDetalleUnidadActual.setHorasEstimadas(evaluacionDetalleUnidad.getHorasEstimadas());
        return evaluacionDetalleUnidadService.save(evaluacionDetalleUnidadActual);
    }

    @DeleteMapping("/evaluacionDetalleUnidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        evaluacionDetalleUnidadService.delete(id);
    }
}

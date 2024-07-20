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

import ista.cursoM4A.entity.EvaluacionDetalleCarrera;
import ista.cursoM4A.services.IEvaluacionDetalleCarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EvaluacionDetalleCarreraRestController {

    @Autowired
    private IEvaluacionDetalleCarreraService evaluacionDetalleCarreraService;

    @GetMapping("/evaluacionDetalleCarrera")
    public List<EvaluacionDetalleCarrera> index() {
        return evaluacionDetalleCarreraService.findAll();
    }

    @GetMapping("/evaluacionDetalleCarrera/{id}")
    public EvaluacionDetalleCarrera show(@PathVariable Long id) {
        return evaluacionDetalleCarreraService.findById(id);
    }

    @PostMapping("/evaluacionDetalleCarrera")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionDetalleCarrera create(@RequestBody EvaluacionDetalleCarrera evaluacionDetalleCarrera) {
        return evaluacionDetalleCarreraService.save(evaluacionDetalleCarrera);
    }

    @PutMapping("/evaluacionDetalleCarrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionDetalleCarrera update(@RequestBody EvaluacionDetalleCarrera evaluacionDetalleCarrera, @PathVariable Long id) {
        EvaluacionDetalleCarrera evaluacionDetalleCarreraActual = evaluacionDetalleCarreraService.findById(id);
        evaluacionDetalleCarreraActual.setCostosFijos(evaluacionDetalleCarrera.getCostosFijos());
        evaluacionDetalleCarreraActual.setDocenteResponsable(evaluacionDetalleCarrera.getDocenteResponsable());
        evaluacionDetalleCarreraActual.setEjecutado(evaluacionDetalleCarrera.getEjecutado());
        evaluacionDetalleCarreraActual.setObservaciones(evaluacionDetalleCarrera.getObservaciones());
        evaluacionDetalleCarreraActual.setEntregable(evaluacionDetalleCarrera.getEntregable());
        evaluacionDetalleCarreraActual.setHorasActuales(evaluacionDetalleCarrera.getHorasActuales());
        evaluacionDetalleCarreraActual.setHorasEstimadas(evaluacionDetalleCarrera.getHorasEstimadas());
        return evaluacionDetalleCarreraService.save(evaluacionDetalleCarreraActual);
    }

    @DeleteMapping("/evaluacionDetalleCarrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        evaluacionDetalleCarreraService.delete(id);
    }
}

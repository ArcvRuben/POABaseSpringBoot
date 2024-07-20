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

import ista.cursoM4A.entity.EvaluacionEncabezadoCarrera;
import ista.cursoM4A.services.IEvaluacionEncabezadoCarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EvaluacionEncabezadoCarreraRestController {

    @Autowired
    private IEvaluacionEncabezadoCarreraService evaluacionEncabezadoCarreraService;

    @GetMapping("/evaluacionEncabezadoCarrera")
    public List<EvaluacionEncabezadoCarrera> index() {
        return evaluacionEncabezadoCarreraService.findAll();
    }

    @GetMapping("/evaluacionEncabezadoCarrera/{id}")
    public EvaluacionEncabezadoCarrera show(@PathVariable Long id) {
        return evaluacionEncabezadoCarreraService.findById(id);
    }

    @PostMapping("/evaluacionEncabezadoCarrera")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionEncabezadoCarrera create(@RequestBody EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera) {
        return evaluacionEncabezadoCarreraService.save(evaluacionEncabezadoCarrera);
    }

    @PutMapping("/evaluacionEncabezadoCarrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EvaluacionEncabezadoCarrera update(@RequestBody EvaluacionEncabezadoCarrera evaluacionEncabezadoCarrera, @PathVariable Long id) {
        EvaluacionEncabezadoCarrera evaluacionEncabezadoCarreraActual = evaluacionEncabezadoCarreraService.findById(id);
        evaluacionEncabezadoCarreraActual.setFecha(evaluacionEncabezadoCarrera.getFecha());
        return evaluacionEncabezadoCarreraService.save(evaluacionEncabezadoCarreraActual);
    }

    @DeleteMapping("/evaluacionEncabezadoCarrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        evaluacionEncabezadoCarreraService.delete(id);
    }
}

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

import ista.cursoM4A.entity.Estrategia;
import ista.cursoM4A.services.IEstrategiaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EstrategiaRestController {

    @Autowired
    private IEstrategiaService estrategiaService;

    @GetMapping("/estrategias")
    public List<Estrategia> index() {
        return estrategiaService.findAll();
    }

    @GetMapping("/estrategias/{id}")
    public Estrategia show(@PathVariable Long id) {
        return estrategiaService.findById(id);
    }

    @PostMapping("/estrategias")
    @ResponseStatus(HttpStatus.CREATED)
    public Estrategia create(@RequestBody Estrategia estrategia) {
        return estrategiaService.save(estrategia);
    }

    @PutMapping("/estrategias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estrategia update(@RequestBody Estrategia estrategia, @PathVariable Long id) {
        Estrategia estrategiaActual = estrategiaService.findById(id);
        estrategiaActual.setDescripcion(estrategia.getDescripcion());
        return estrategiaService.save(estrategiaActual);
    }

    @DeleteMapping("/estrategias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        estrategiaService.delete(id);
    }
}

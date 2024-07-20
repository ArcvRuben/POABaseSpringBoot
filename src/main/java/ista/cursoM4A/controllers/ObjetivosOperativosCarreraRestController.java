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

import ista.cursoM4A.entity.ObjetivosOperativosCarrera;
import ista.cursoM4A.services.IObjetivosOperativosCarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ObjetivosOperativosCarreraRestController {

    @Autowired
    private IObjetivosOperativosCarreraService objetivosOperativosCarreraService;

    @GetMapping("/objetivosOperativosCarrera")
    public List<ObjetivosOperativosCarrera> index() {
        return objetivosOperativosCarreraService.findAll();
    }

    @GetMapping("/objetivosOperativosCarrera/{id}")
    public ObjetivosOperativosCarrera show(@PathVariable Long id) {
        return objetivosOperativosCarreraService.findById(id);
    }

    @PostMapping("/objetivosOperativosCarrera")
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivosOperativosCarrera create(@RequestBody ObjetivosOperativosCarrera objetivosOperativosCarrera) {
        return objetivosOperativosCarreraService.save(objetivosOperativosCarrera);
    }

    @PutMapping("/objetivosOperativosCarrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivosOperativosCarrera update(@RequestBody ObjetivosOperativosCarrera objetivosOperativosCarrera, @PathVariable Long id) {
        ObjetivosOperativosCarrera objetivosOperativosCarreraActual = objetivosOperativosCarreraService.findById(id);
        objetivosOperativosCarreraActual.setDescripcion(objetivosOperativosCarrera.getDescripcion());
        return objetivosOperativosCarreraService.save(objetivosOperativosCarreraActual);
    }

    @DeleteMapping("/objetivosOperativosCarrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        objetivosOperativosCarreraService.delete(id);
    }
}

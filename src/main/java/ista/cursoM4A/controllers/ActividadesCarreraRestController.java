package ista.cursoM4A.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ista.cursoM4A.entity.ActividadesCarrera;
import ista.cursoM4A.services.IActividadesCarreraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ActividadesCarreraRestController {

    @Autowired
    private IActividadesCarreraService actividadesCarreraService;

    @GetMapping("/actividadesCarrera")
    public List<ActividadesCarrera> index() {
        return actividadesCarreraService.findAll();
    }

    @GetMapping("/actividadesCarrera/{id}")
    public ActividadesCarrera show(@PathVariable Long id) {
        return actividadesCarreraService.findById(id);
    }

    @PostMapping("/actividadesCarrera")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadesCarrera create(@RequestBody ActividadesCarrera actividadesCarrera) {
        return actividadesCarreraService.save(actividadesCarrera);
    }

    @PutMapping("/actividadesCarrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadesCarrera update(@RequestBody ActividadesCarrera actividadesCarrera, @PathVariable Long id) {
        ActividadesCarrera actividadesCarreraActual = actividadesCarreraService.findById(id);
        actividadesCarreraActual.setDescripcion(actividadesCarrera.getDescripcion());
        actividadesCarreraActual.setResponsable(actividadesCarrera.getResponsable());
        actividadesCarreraActual.setPlazo(actividadesCarrera.getPlazo());
        actividadesCarreraActual.setEntregable(actividadesCarrera.getEntregable());
        actividadesCarreraActual.setMeta(actividadesCarrera.getMeta());
        actividadesCarreraActual.setRecFinIeta(actividadesCarrera.getRecFinIeta());
        actividadesCarreraActual.setRecFinAutogestion(actividadesCarrera.getRecFinAutogestion());
        return actividadesCarreraService.save(actividadesCarreraActual);
    }

    @DeleteMapping("/actividadesCarrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        actividadesCarreraService.delete(id);
    }

    @PostMapping("/actividadesCarrera/upload")
    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        if (!file.isEmpty()) {
            try {
                ActividadesCarrera actividad = actividadesCarreraService.findById(id);
                actividad.setEntregable(file.getBytes());
                actividadesCarreraService.save(actividad);
                return new ResponseEntity<>("Archivo subido con éxito", HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Error al subir el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>("El archivo está vacío", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/actividadesCarrera/download/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        ActividadesCarrera actividad = actividadesCarreraService.findById(id);
        byte[] pdfBytes = actividad.getEntregable();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"entregable.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}

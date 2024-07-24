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

import ista.cursoM4A.entity.ActividadesUnidad;
import ista.cursoM4A.services.IActividadesUnidadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ActividadesUnidadRestController {

    @Autowired
    private IActividadesUnidadService actividadesUnidadService;

    @GetMapping("/actividadesUnidad")
    public List<ActividadesUnidad> index() {
        return actividadesUnidadService.findAll();
    }

    @GetMapping("/actividadesUnidad/{id}")
    public ActividadesUnidad show(@PathVariable Long id) {
        return actividadesUnidadService.findById(id);
    }

    @PostMapping("/actividadesUnidad")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadesUnidad create(@RequestBody ActividadesUnidad actividadesUnidad) {
        return actividadesUnidadService.save(actividadesUnidad);
    }

    @PutMapping("/actividadesUnidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadesUnidad update(@RequestBody ActividadesUnidad actividadesUnidad, @PathVariable Long id) {
        ActividadesUnidad actividadesUnidadActual = actividadesUnidadService.findById(id);
        actividadesUnidadActual.setDescripcion(actividadesUnidad.getDescripcion());
        actividadesUnidadActual.setResponsable(actividadesUnidad.getResponsable());
        actividadesUnidadActual.setPlazo(actividadesUnidad.getPlazo());
        actividadesUnidadActual.setEntregable(actividadesUnidad.getEntregable());
        actividadesUnidadActual.setMeta(actividadesUnidad.getMeta());
        actividadesUnidadActual.setRecFinIsta(actividadesUnidad.getRecFinIsta());
        actividadesUnidadActual.setRecFinAutogestion(actividadesUnidad.getRecFinAutogestion());
        return actividadesUnidadService.save(actividadesUnidadActual);
    }

    @DeleteMapping("/actividadesUnidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        actividadesUnidadService.delete(id);
    }

    @PostMapping("/actividadesUnidad/upload")
    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        if (!file.isEmpty()) {
            try {
                ActividadesUnidad actividad = actividadesUnidadService.findById(id);
                actividad.setEntregable(file.getBytes());
                actividadesUnidadService.save(actividad);
                return new ResponseEntity<>("Archivo cargado exitosamente", HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>("El archivo está vacío", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/actividadesUnidad/download/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        ActividadesUnidad actividad = actividadesUnidadService.findById(id);
        byte[] pdfBytes = actividad.getEntregable();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"entregable.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}

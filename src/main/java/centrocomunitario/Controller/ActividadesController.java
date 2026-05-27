package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.*;
import centrocomunitario.Service.IActividadesService;

@RestController
@RequestMapping("/UAO/apirest/actividades")
public class ActividadesController {
    @Autowired IActividadesService actividadesService;

    @PostMapping("/")
    public ResponseEntity<ActividadesModel> crearActividad(@RequestBody ActividadesModel actividad) {
        return new ResponseEntity<>(actividadesService.crearActividad(actividad), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ActividadesModel>> listarActividades() {
        return new ResponseEntity<>(actividadesService.listarActividades(), HttpStatus.OK);
    }

    @PostMapping("/{id}/inscripciones")
    public ResponseEntity<Inscripcion> agregarInscripcion(@PathVariable("id") String idActividad, @RequestBody Inscripcion inscripcion) {
        try {
            ObjectId objectId = new ObjectId(idActividad);
            return new ResponseEntity<>(actividadesService.agregarInscripcion(objectId, inscripcion), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/evaluaciones")
    public ResponseEntity<Evaluacion> agregarEvaluacion(@PathVariable("id") String idActividad, @RequestBody Evaluacion evaluacion) {
        try {
            ObjectId objectId = new ObjectId(idActividad);
            return new ResponseEntity<>(actividadesService.agregarEvaluacion(objectId, evaluacion), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/seguimientos")
    public ResponseEntity<Seguimiento> agregarSeguimiento(@PathVariable("id") String idActividad, @RequestBody Seguimiento seguimiento) {
        try {
            ObjectId objectId = new ObjectId(idActividad);
            return new ResponseEntity<>(actividadesService.agregarSeguimiento(objectId, seguimiento), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ActividadesModel>> buscarPorCategoria(@PathVariable("categoria") String categoria) {
        return new ResponseEntity<>(actividadesService.buscarPorCategoria(categoria), HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ActividadesModel>> buscarPorEstado(@PathVariable("estado") String estado) {
        return new ResponseEntity<>(actividadesService.buscarPorEstado(estado), HttpStatus.OK);
    }
}

package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.*;
import centrocomunitario.Service.ISesionesService;

@RestController
@RequestMapping("/UAO/apirest/sesiones")
public class SesionesController {
    @Autowired ISesionesService sesionesService;

    @PostMapping("/")
    public ResponseEntity<SesionesModel> crearSesion(@RequestBody SesionesModel sesion) {
        return new ResponseEntity<>(sesionesService.crearSesion(sesion), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<SesionesModel>> listarSesiones() {
        return new ResponseEntity<>(sesionesService.listarSesiones(), HttpStatus.OK);
    }

    @PostMapping("/{id}/participantes")
    public ResponseEntity<ParticipanteConvocado> agregarParticipante(@PathVariable("id") String idSesion, @RequestBody ParticipanteConvocado participante) {
        try {
            ObjectId objectId = new ObjectId(idSesion);
            return new ResponseEntity<>(sesionesService.agregarParticipante(objectId, participante), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/asistencia")
    public ResponseEntity<Asistencia> registrarAsistencia(@PathVariable("id") String idSesion, @RequestBody Asistencia asistencia) {
        try {
            ObjectId objectId = new ObjectId(idSesion);
            return new ResponseEntity<>(sesionesService.registrarAsistencia(objectId, asistencia), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/archivos")
    public ResponseEntity<ArchivoAdjunto> agregarArchivo(@PathVariable("id") String idSesion, @RequestBody ArchivoAdjunto archivo) {
        try {
            ObjectId objectId = new ObjectId(idSesion);
            return new ResponseEntity<>(sesionesService.agregarArchivo(objectId, archivo), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/modalidad/{modalidad}")
    public ResponseEntity<List<SesionesModel>> buscarPorModalidad(@PathVariable("modalidad") String modalidad) {
        return new ResponseEntity<>(sesionesService.buscarPorModalidad(modalidad), HttpStatus.OK);
    }

    @GetMapping("/actividad/{actividadId}")
    public ResponseEntity<List<SesionesModel>> buscarPorActividad(@PathVariable("actividadId") String actividadId) {
        try {
            ObjectId objectId = new ObjectId(actividadId);
            return new ResponseEntity<>(sesionesService.buscarPorActividad(objectId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

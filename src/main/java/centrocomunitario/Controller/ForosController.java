package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.ForosModel;
import centrocomunitario.Service.IForosService;

@RestController
@RequestMapping("/UAO/apirest/foros")
public class ForosController {
    @Autowired IForosService forosService;

    @PostMapping("/")
    public ResponseEntity<ForosModel> crearForo(@RequestBody ForosModel foro) {
        return new ResponseEntity<>(forosService.crearForo(foro), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ForosModel>> listarForos() {
        return new ResponseEntity<>(forosService.listarForos(), HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ForosModel>> buscarPorEstado(@PathVariable("estado") String estado) {
        return new ResponseEntity<>(forosService.buscarPorEstado(estado), HttpStatus.OK);
    }

    @GetMapping("/actividad/{actividadId}")
    public ResponseEntity<List<ForosModel>> buscarPorActividad(@PathVariable("actividadId") String actividadId) {
        try {
            ObjectId objectId = new ObjectId(actividadId);
            return new ResponseEntity<>(forosService.buscarPorActividad(objectId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // AGREGACION: foros creados por instructores
    @GetMapping("/reporte/de-instructores")
    public ResponseEntity<List<ForosModel>> forosDeInstructores() {
        return new ResponseEntity<>(forosService.forosDeInstructores(), HttpStatus.OK);
    }
}

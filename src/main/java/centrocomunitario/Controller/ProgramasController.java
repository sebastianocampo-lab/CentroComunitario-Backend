package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.InscripcionPrograma;
import centrocomunitario.Model.ProgramasModel;
import centrocomunitario.Service.IProgramasService;

@RestController
@RequestMapping("/UAO/apirest/programas")
public class ProgramasController {
    @Autowired IProgramasService programasService;

    @PostMapping("/")
    public ResponseEntity<ProgramasModel> crearPrograma(@RequestBody ProgramasModel programa) {
        return new ResponseEntity<>(programasService.crearPrograma(programa), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProgramasModel>> listarProgramas() {
        return new ResponseEntity<>(programasService.listarProgramas(), HttpStatus.OK);
    }

    @PostMapping("/{id}/inscripciones")
    public ResponseEntity<InscripcionPrograma> agregarInscripcion(@PathVariable("id") String idPrograma, @RequestBody InscripcionPrograma inscripcion) {
        try {
            ObjectId objectId = new ObjectId(idPrograma);
            return new ResponseEntity<>(programasService.agregarInscripcion(objectId, inscripcion), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ProgramasModel>> buscarPorEstado(@PathVariable("estado") String estado) {
        return new ResponseEntity<>(programasService.buscarPorEstado(estado), HttpStatus.OK);
    }

    @GetMapping("/poblacion/{poblacion}")
    public ResponseEntity<List<ProgramasModel>> buscarPorPoblacion(@PathVariable("poblacion") String poblacion) {
        return new ResponseEntity<>(programasService.buscarPorPoblacion(poblacion), HttpStatus.OK);
    }
}

package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.EspaciosModel;
import centrocomunitario.Model.Recurso;
import centrocomunitario.Service.IEspaciosService;

@RestController
@RequestMapping("/UAO/apirest/espacios")
public class EspaciosController {
    @Autowired IEspaciosService espaciosService;

    @PostMapping("/")
    public ResponseEntity<EspaciosModel> crearEspacio(@RequestBody EspaciosModel espacio) {
        return new ResponseEntity<>(espaciosService.crearEspacio(espacio), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<EspaciosModel>> listarEspacios() {
        return new ResponseEntity<>(espaciosService.listarEspacios(), HttpStatus.OK);
    }

    @PostMapping("/{id}/recursos")
    public ResponseEntity<Recurso> agregarRecurso(@PathVariable("id") String idEspacio, @RequestBody Recurso recurso) {
        try {
            ObjectId objectId = new ObjectId(idEspacio);
            return new ResponseEntity<>(espaciosService.agregarRecurso(objectId, recurso), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<EspaciosModel>> buscarDisponibles() {
        return new ResponseEntity<>(espaciosService.buscarDisponibles(), HttpStatus.OK);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<EspaciosModel>> buscarPorTipo(@PathVariable("tipo") String tipo) {
        return new ResponseEntity<>(espaciosService.buscarPorTipo(tipo), HttpStatus.OK);
    }
}

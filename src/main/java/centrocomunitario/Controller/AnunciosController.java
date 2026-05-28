package centrocomunitario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.AnunciosModel;
import centrocomunitario.Service.IAnunciosService;

@RestController
@RequestMapping("/UAO/apirest/anuncios")
public class AnunciosController {
    @Autowired IAnunciosService anunciosService;

    @PostMapping("/")
    public ResponseEntity<AnunciosModel> crearAnuncio(@RequestBody AnunciosModel anuncio) {
        return new ResponseEntity<>(anunciosService.crearAnuncio(anuncio), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AnunciosModel>> listarAnuncios() {
        return new ResponseEntity<>(anunciosService.listarAnuncios(), HttpStatus.OK);
    }

    @GetMapping("/visibles")
    public ResponseEntity<List<AnunciosModel>> buscarVisibles() {
        return new ResponseEntity<>(anunciosService.buscarVisibles(), HttpStatus.OK);
    }

    @GetMapping("/audiencia/{audiencia}")
    public ResponseEntity<List<AnunciosModel>> buscarPorAudiencia(@PathVariable("audiencia") String audiencia) {
        return new ResponseEntity<>(anunciosService.buscarPorAudiencia(audiencia), HttpStatus.OK);
    }

    // AGREGACION: anuncios creados por coordinadores
    @GetMapping("/reporte/de-coordinadores")
    public ResponseEntity<List<AnunciosModel>> anunciosDeCoordinadores() {
        return new ResponseEntity<>(anunciosService.anunciosDeCoordinadores(), HttpStatus.OK);
    }
}

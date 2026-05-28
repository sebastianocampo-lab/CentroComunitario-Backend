package centrocomunitario.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import centrocomunitario.Model.ComentariosModel;
import centrocomunitario.Model.ReplicaComentario;
import centrocomunitario.Service.IComentariosService;

@RestController
@RequestMapping("/UAO/apirest/comentarios")
public class ComentariosController {
    @Autowired IComentariosService comentariosService;

    @PostMapping("/")
    public ResponseEntity<ComentariosModel> crearComentario(@RequestBody ComentariosModel comentario) {
        return new ResponseEntity<>(comentariosService.crearComentario(comentario), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ComentariosModel>> listarComentarios() {
        return new ResponseEntity<>(comentariosService.listarComentarios(), HttpStatus.OK);
    }

    @PostMapping("/{id}/replicas")
    public ResponseEntity<ReplicaComentario> agregarReplica(@PathVariable("id") String idComentario, @RequestBody ReplicaComentario replica) {
        try {
            ObjectId objectId = new ObjectId(idComentario);
            return new ResponseEntity<>(comentariosService.agregarReplica(objectId, replica), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/foro/{foroId}")
    public ResponseEntity<List<ComentariosModel>> buscarPorForo(@PathVariable("foroId") String foroId) {
        try {
            ObjectId objectId = new ObjectId(foroId);
            return new ResponseEntity<>(comentariosService.buscarPorForo(objectId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sin-replicas")
    public ResponseEntity<List<ComentariosModel>> buscarSinReplicas() {
        return new ResponseEntity<>(comentariosService.buscarSinReplicas(), HttpStatus.OK);
    }

    // AGREGACION: comentarios que pertenecen a foros abiertos
    @GetMapping("/reporte/de-foros-abiertos")
    public ResponseEntity<List<ComentariosModel>> comentariosDeForosAbiertos() {
        return new ResponseEntity<>(comentariosService.comentariosDeForosAbiertos(), HttpStatus.OK);
    }
}

package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.ComentariosModel;
import centrocomunitario.Model.ReplicaComentario;
import centrocomunitario.Repository.IComentariosRepository;
import centrocomunitario.Repository.IForosRepository;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class ComentariosServiceImp implements IComentariosService {
    @Autowired IComentariosRepository comentariosRepository;
    @Autowired IForosRepository forosRepository;
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public ComentariosModel crearComentario(ComentariosModel comentario) {
    if (comentario.getForo_id() == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "foro_id es requerido");
    }
    if (!forosRepository.existsById(comentario.getForo_id())) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "foro_id del comentario no existe");
    }
    if (!usuariosRepository.existsById(comentario.getUsuario_id())) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario_id del comentario no existe");
    }
    comentario.setFecha_publicacion(java.time.LocalDate.now());
    // Inicializar arrays vacíos
    if (comentario.getArchivos_adjuntos() == null) comentario.setArchivos_adjuntos(new java.util.ArrayList<>());
    if (comentario.getReplicas_comentarios() == null) comentario.setReplicas_comentarios(new java.util.ArrayList<>());
    return comentariosRepository.save(comentario);
}

    @Override
    public List<ComentariosModel> listarComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    public ReplicaComentario agregarReplica(ObjectId idComentario, ReplicaComentario replica) {
        ComentariosModel comentario = comentariosRepository.findById(idComentario)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id del comentario no existe"));
        if (!usuariosRepository.existsById(replica.getUsuario_id())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario_id de la replica no existe");
        }
        replica.setFecha_publicacion(LocalDate.now());
        comentario.getReplicas_comentarios().add(replica);
        comentariosRepository.save(comentario);
        return replica;
    }

    @Override
    public List<ComentariosModel> buscarPorForo(ObjectId foroId) {
        return comentariosRepository.buscarPorForo(foroId);
    }

    @Override
    public List<ComentariosModel> buscarSinReplicas() {
        return comentariosRepository.buscarSinReplicas();
    }

    @Override
    public List<ComentariosModel> comentariosDeForosAbiertos() {
        return comentariosRepository.comentariosDeForosAbiertos();
    }
}

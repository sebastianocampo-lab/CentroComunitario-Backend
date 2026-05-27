package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.ComentariosModel;
import centrocomunitario.Model.ReplicaComentario;

public interface IComentariosService {
    ComentariosModel crearComentario(ComentariosModel comentario);
    List<ComentariosModel> listarComentarios();
    ReplicaComentario agregarReplica(ObjectId idComentario, ReplicaComentario replica);
    List<ComentariosModel> buscarPorForo(ObjectId foroId);
    List<ComentariosModel> buscarSinReplicas();
}

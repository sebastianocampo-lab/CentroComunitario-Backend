package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.ComentariosModel;

public interface IComentariosRepository extends MongoRepository<ComentariosModel, ObjectId> {
    //consultas nativas

    // Buscar comentarios de un foro especifico
    @Query("{ 'foro_id': ?0 }")
    List<ComentariosModel> buscarPorForo(ObjectId foroId);

    // Buscar comentarios sin replicas (array vacio)
    @Query("{ 'replicas_comentarios': { $size: 0 } }")
    List<ComentariosModel> buscarSinReplicas();
}

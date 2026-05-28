package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.ForosModel;

public interface IForosRepository extends MongoRepository<ForosModel, ObjectId> {
    //consultas nativas

    // Buscar foros por estado (abierto, cerrado, archivado)
    @Query("{ 'estado': ?0 }")
    List<ForosModel> buscarPorEstado(String estado);

    // Buscar foros de una actividad especifica
    @Query("{ 'actividad_id': ?0 }")
    List<ForosModel> buscarPorActividad(ObjectId actividadId);

    // AGREGACION: foros creados por usuarios con rol instructor
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'usuarios', localField: 'autor_id', foreignField: '_id', as: 'autor' } }",
        "{ $unwind: '$autor' }",
        "{ $match: { 'autor.rol': 'instructor' } }",
        "{ $project: { autor: 0 } }"
    })
    List<ForosModel> forosDeInstructores();
}

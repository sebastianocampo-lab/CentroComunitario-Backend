package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
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
}

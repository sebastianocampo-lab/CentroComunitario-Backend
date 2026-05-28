package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.SesionesModel;

public interface ISesionesRepository extends MongoRepository<SesionesModel, ObjectId> {
    //consultas nativas

    // Buscar sesiones por modalidad (presencial, virtual, hibrida)
    @Query("{ 'modalidad': ?0 }")
    List<SesionesModel> buscarPorModalidad(String modalidad);

    // Buscar sesiones de una actividad especifica
    @Query("{ 'actividad_id': ?0 }")
    List<SesionesModel> buscarPorActividad(ObjectId actividadId);

    // AGREGACION: sesiones cuyas actividades estan en curso
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'actividades', localField: 'actividad_id', foreignField: '_id', as: 'actividad' } }",
        "{ $unwind: '$actividad' }",
        "{ $match: { 'actividad.estado': 'en_curso' } }",
        "{ $project: { actividad: 0 } }"
    })
    List<SesionesModel> sesionesDeActividadesEnCurso();
}

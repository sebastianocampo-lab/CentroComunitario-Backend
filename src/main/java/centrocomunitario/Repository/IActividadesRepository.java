package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.ActividadesModel;

public interface IActividadesRepository extends MongoRepository<ActividadesModel, ObjectId> {
    //consultas nativas

    // Buscar actividades por categoria
    @Query("{ 'categoria': ?0 }")
    List<ActividadesModel> buscarPorCategoria(String categoria);

    // Buscar actividades por estado
    @Query("{ 'estado': ?0 }")
    List<ActividadesModel> buscarPorEstado(String estado);

    // AGREGACION: actividades propuestas por usuarios con rol lider_comunitario
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'usuarios', localField: 'propuesto_por', foreignField: '_id', as: 'proponente' } }",
        "{ $unwind: '$proponente' }",
        "{ $match: { 'proponente.rol': 'lider_comunitario' } }",
        "{ $project: { proponente: 0 } }"
    })
    List<ActividadesModel> actividadesDeLideresComunitarios();
}

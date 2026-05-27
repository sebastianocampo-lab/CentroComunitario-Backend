package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.AnunciosModel;

public interface IAnunciosRepository extends MongoRepository<AnunciosModel, ObjectId> {
    //consultas nativas

    // Buscar anuncios visibles
    @Query("{ 'visible': true }")
    List<AnunciosModel> buscarVisibles();

    // Buscar anuncios por audiencia (dirigido_a)
    @Query("{ 'dirigido_a': ?0 }")
    List<AnunciosModel> buscarPorAudiencia(String audiencia);
}

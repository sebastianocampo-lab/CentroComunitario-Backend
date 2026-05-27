package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.EspaciosModel;

public interface IEspaciosRepository extends MongoRepository<EspaciosModel, ObjectId> {
    //consultas nativas

    // Buscar espacios disponibles
    @Query("{ 'disponible': true }")
    List<EspaciosModel> buscarDisponibles();

    // Buscar espacios por tipo (aula, salon, auditorio, virtual, etc.)
    @Query("{ 'tipo': ?0 }")
    List<EspaciosModel> buscarPorTipo(String tipo);
}

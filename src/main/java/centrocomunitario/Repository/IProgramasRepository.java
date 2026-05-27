package centrocomunitario.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import centrocomunitario.Model.ProgramasModel;

public interface IProgramasRepository extends MongoRepository<ProgramasModel, ObjectId> {
    //consultas nativas

    // Buscar programas por estado (planificado, en_curso, finalizado, cancelado)
    @Query("{ 'estado': ?0 }")
    List<ProgramasModel> buscarPorEstado(String estado);

    // Buscar programas por poblacion objetivo (contiene texto, sin importar mayusculas)
    @Query("{ 'poblacion_objetivo': { $regex: ?0, $options: 'i' } }")
    List<ProgramasModel> buscarPorPoblacion(String poblacion);
}

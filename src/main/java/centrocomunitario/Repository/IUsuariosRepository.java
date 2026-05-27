package centrocomunitario.Repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import centrocomunitario.Model.UsuariosModel;

public interface IUsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {
    //consultas nativas

    // Buscar usuarios por rol
    @Query("{ 'rol': ?0 }")
    List<UsuariosModel> buscarPorRol(String rol);

    // Buscar usuarios activos
    @Query("{ 'activo': true }")
    List<UsuariosModel> buscarActivos();
}
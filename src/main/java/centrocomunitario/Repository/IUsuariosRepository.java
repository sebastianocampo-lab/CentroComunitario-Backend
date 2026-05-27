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

    // Buscar usuario por correo electronico
    @Query("{ 'correo_electronico': ?0 }")
    UsuariosModel buscarPorCorreo(String correo);

    // Buscar usuarios por nombre (contiene texto, sin importar mayusculas)
    @Query("{ 'nombre_completo': { $regex: ?0, $options: 'i' } }")
    List<UsuariosModel> buscarPorNombre(String nombre);

    // Buscar usuarios mayores de cierta edad
    @Query("{ 'edad': { $gte: ?0 } }")
    List<UsuariosModel> buscarPorEdadMinima(int edad);
}

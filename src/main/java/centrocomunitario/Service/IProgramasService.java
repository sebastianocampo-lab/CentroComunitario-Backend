package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.*;

public interface IProgramasService {
    ProgramasModel crearPrograma(ProgramasModel programa);
    List<ProgramasModel> listarProgramas();
    InscripcionPrograma agregarInscripcion(ObjectId idPrograma, InscripcionPrograma inscripcion);
    List<ProgramasModel> buscarPorEstado(String estado);
    List<ProgramasModel> buscarPorPoblacion(String poblacion);
}

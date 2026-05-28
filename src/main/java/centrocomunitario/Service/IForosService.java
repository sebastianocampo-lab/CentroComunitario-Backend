package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.ForosModel;

public interface IForosService {
    ForosModel crearForo(ForosModel foro);
    List<ForosModel> listarForos();
    List<ForosModel> buscarPorEstado(String estado);
    List<ForosModel> buscarPorActividad(ObjectId actividadId);
    List<ForosModel> forosDeInstructores();
}

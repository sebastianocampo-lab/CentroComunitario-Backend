package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.EspaciosModel;
import centrocomunitario.Model.Recurso;

public interface IEspaciosService {
    EspaciosModel crearEspacio(EspaciosModel espacio);
    List<EspaciosModel> listarEspacios();
    Recurso agregarRecurso(ObjectId idEspacio, Recurso recurso);
    List<EspaciosModel> buscarDisponibles();
    List<EspaciosModel> buscarPorTipo(String tipo);
}

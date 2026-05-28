package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.*;

public interface IActividadesService {
    ActividadesModel crearActividad(ActividadesModel actividad);
    List<ActividadesModel> listarActividades();
    Inscripcion agregarInscripcion(ObjectId idActividad, Inscripcion inscripcion);
    Evaluacion agregarEvaluacion(ObjectId idActividad, Evaluacion evaluacion);
    Seguimiento agregarSeguimiento(ObjectId idActividad, Seguimiento seguimiento);
    List<ActividadesModel> buscarPorCategoria(String categoria);
    List<ActividadesModel> buscarPorEstado(String estado);
    List<ActividadesModel> actividadesDeLideresComunitarios();
}

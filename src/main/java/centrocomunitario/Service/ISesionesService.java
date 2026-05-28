package centrocomunitario.Service;

import java.util.List;
import org.bson.types.ObjectId;
import centrocomunitario.Model.*;

public interface ISesionesService {
    SesionesModel crearSesion(SesionesModel sesion);
    List<SesionesModel> listarSesiones();
    ParticipanteConvocado agregarParticipante(ObjectId idSesion, ParticipanteConvocado participante);
    Asistencia registrarAsistencia(ObjectId idSesion, Asistencia asistencia);
    ArchivoAdjunto agregarArchivo(ObjectId idSesion, ArchivoAdjunto archivo);
    List<SesionesModel> buscarPorModalidad(String modalidad);
    List<SesionesModel> buscarPorActividad(ObjectId actividadId);
    List<SesionesModel> sesionesDeActividadesEnCurso();
}

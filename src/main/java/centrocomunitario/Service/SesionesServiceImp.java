package centrocomunitario.Service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.*;
import centrocomunitario.Repository.IActividadesRepository;
import centrocomunitario.Repository.ISesionesRepository;

@Service
public class SesionesServiceImp implements ISesionesService {
    @Autowired ISesionesRepository sesionesRepository;
    @Autowired IActividadesRepository actividadesRepository;

    @Override
    public SesionesModel crearSesion(SesionesModel sesion) {
    if (sesion.getActividad_id() == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "actividad_id es requerido");
    }
    if (!actividadesRepository.existsById(sesion.getActividad_id())) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "actividad_id de la sesion no existe");
    }
    // Inicializar arrays vacíos para que MongoDB no los omita
    if (sesion.getParticipantes_convocados() == null) sesion.setParticipantes_convocados(new java.util.ArrayList<>());
    if (sesion.getAsistencia() == null) sesion.setAsistencia(new java.util.ArrayList<>());
    if (sesion.getArchivos_adjuntos() == null) sesion.setArchivos_adjuntos(new java.util.ArrayList<>());
    return sesionesRepository.save(sesion);
}

    @Override
    public List<SesionesModel> listarSesiones() {
        return sesionesRepository.findAll();
    }

    @Override
    public ParticipanteConvocado agregarParticipante(ObjectId idSesion, ParticipanteConvocado participante) {
        SesionesModel sesion = sesionesRepository.findById(idSesion)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la sesion no existe"));
        sesion.getParticipantes_convocados().add(participante);
        sesionesRepository.save(sesion);
        return participante;
    }

    @Override
    public Asistencia registrarAsistencia(ObjectId idSesion, Asistencia asistencia) {
        SesionesModel sesion = sesionesRepository.findById(idSesion)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la sesion no existe"));
        sesion.getAsistencia().add(asistencia);
        sesionesRepository.save(sesion);
        return asistencia;
    }

    @Override
    public ArchivoAdjunto agregarArchivo(ObjectId idSesion, ArchivoAdjunto archivo) {
        SesionesModel sesion = sesionesRepository.findById(idSesion)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la sesion no existe"));
        sesion.getArchivos_adjuntos().add(archivo);
        sesionesRepository.save(sesion);
        return archivo;
    }

    @Override
    public List<SesionesModel> buscarPorModalidad(String modalidad) {
        return sesionesRepository.buscarPorModalidad(modalidad);
    }

    @Override
    public List<SesionesModel> buscarPorActividad(ObjectId actividadId) {
        return sesionesRepository.buscarPorActividad(actividadId);
    }

    @Override
    public List<SesionesModel> sesionesDeActividadesEnCurso() {
        return sesionesRepository.sesionesDeActividadesEnCurso();
    }
}

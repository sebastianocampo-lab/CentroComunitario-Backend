package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.*;
import centrocomunitario.Repository.IActividadesRepository;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class ActividadesServiceImp implements IActividadesService {
    @Autowired IActividadesRepository actividadesRepository;
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public ActividadesModel crearActividad(ActividadesModel actividad) {
        return actividadesRepository.save(actividad);
    }

    @Override
    public List<ActividadesModel> listarActividades() {
        return actividadesRepository.findAll();
    }

    @Override
    public Inscripcion agregarInscripcion(ObjectId idActividad, Inscripcion inscripcion) {
        ActividadesModel actividad = actividadesRepository.findById(idActividad)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la actividad no existe"));
        if (!usuariosRepository.existsById(inscripcion.getUsuario_id())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario_id de la inscripcion no existe");
        }
        inscripcion.setFecha_inscripcion(LocalDate.now());
        actividad.getInscripciones().add(inscripcion);
        actividadesRepository.save(actividad);
        return inscripcion;
    }

    @Override
    public Evaluacion agregarEvaluacion(ObjectId idActividad, Evaluacion evaluacion) {
        ActividadesModel actividad = actividadesRepository.findById(idActividad)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la actividad no existe"));
        evaluacion.setFecha(LocalDate.now());
        actividad.getEvaluaciones().add(evaluacion);
        actividadesRepository.save(actividad);
        return evaluacion;
    }

    @Override
    public Seguimiento agregarSeguimiento(ObjectId idActividad, Seguimiento seguimiento) {
        ActividadesModel actividad = actividadesRepository.findById(idActividad)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id de la actividad no existe"));
        seguimiento.setFecha(LocalDate.now());
        actividad.getSeguimientos().add(seguimiento);
        actividadesRepository.save(actividad);
        return seguimiento;
    }

    @Override
    public List<ActividadesModel> buscarPorCategoria(String categoria) {
        return actividadesRepository.buscarPorCategoria(categoria);
    }

    @Override
    public List<ActividadesModel> buscarPorEstado(String estado) {
        return actividadesRepository.buscarPorEstado(estado);
    }

    @Override
    public List<ActividadesModel> actividadesDeLideresComunitarios() {
        return actividadesRepository.actividadesDeLideresComunitarios();
    }
}

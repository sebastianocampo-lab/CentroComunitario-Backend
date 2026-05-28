package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.ForosModel;
import centrocomunitario.Repository.IForosRepository;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class ForosServiceImp implements IForosService {
    @Autowired IForosRepository forosRepository;
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public ForosModel crearForo(ForosModel foro) {
        if (foro.getAutor_id() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "autor_id es requerido");
        }
        if (!usuariosRepository.existsById(foro.getAutor_id())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "autor_id del foro no existe");
        }
        foro.setFecha_creacion(LocalDate.now());
        return forosRepository.save(foro);
    }

    @Override
    public List<ForosModel> listarForos() {
        return forosRepository.findAll();
    }

    @Override
    public List<ForosModel> buscarPorEstado(String estado) {
        return forosRepository.buscarPorEstado(estado);
    }

    @Override
    public List<ForosModel> buscarPorActividad(ObjectId actividadId) {
        return forosRepository.buscarPorActividad(actividadId);
    }

    @Override
    public List<ForosModel> forosDeInstructores() {
        return forosRepository.forosDeInstructores();
    }
}

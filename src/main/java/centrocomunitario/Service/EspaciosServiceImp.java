package centrocomunitario.Service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.EspaciosModel;
import centrocomunitario.Model.Recurso;
import centrocomunitario.Repository.IEspaciosRepository;

@Service
public class EspaciosServiceImp implements IEspaciosService {
    @Autowired IEspaciosRepository espaciosRepository;

    @Override
    public EspaciosModel crearEspacio(EspaciosModel espacio) {
        return espaciosRepository.save(espacio);
    }

    @Override
    public List<EspaciosModel> listarEspacios() {
        return espaciosRepository.findAll();
    }

    @Override
    public Recurso agregarRecurso(ObjectId idEspacio, Recurso recurso) {
        EspaciosModel espacio = espaciosRepository.findById(idEspacio)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id del espacio no existe"));
        espacio.getRecursos().add(recurso);
        espaciosRepository.save(espacio);
        return recurso;
    }

    @Override
    public List<EspaciosModel> buscarDisponibles() {
        return espaciosRepository.buscarDisponibles();
    }

    @Override
    public List<EspaciosModel> buscarPorTipo(String tipo) {
        return espaciosRepository.buscarPorTipo(tipo);
    }
}

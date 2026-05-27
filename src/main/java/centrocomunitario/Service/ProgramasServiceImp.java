package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.InscripcionPrograma;
import centrocomunitario.Model.ProgramasModel;
import centrocomunitario.Repository.IProgramasRepository;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class ProgramasServiceImp implements IProgramasService {
    @Autowired IProgramasRepository programasRepository;
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public ProgramasModel crearPrograma(ProgramasModel programa) {
        return programasRepository.save(programa);
    }

    @Override
    public List<ProgramasModel> listarProgramas() {
        return programasRepository.findAll();
    }

    @Override
    public InscripcionPrograma agregarInscripcion(ObjectId idPrograma, InscripcionPrograma inscripcion) {
        ProgramasModel programa = programasRepository.findById(idPrograma)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El id del programa no existe"));
        if (!usuariosRepository.existsById(inscripcion.getUsuario_id())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario_id de la inscripcion no existe");
        }
        inscripcion.setFecha_inscripcion(LocalDate.now());
        programa.getInscripciones_programa().add(inscripcion);
        programasRepository.save(programa);
        return inscripcion;
    }

    @Override
    public List<ProgramasModel> buscarPorEstado(String estado) {
        return programasRepository.buscarPorEstado(estado);
    }

    @Override
    public List<ProgramasModel> buscarPorPoblacion(String poblacion) {
        return programasRepository.buscarPorPoblacion(poblacion);
    }
}

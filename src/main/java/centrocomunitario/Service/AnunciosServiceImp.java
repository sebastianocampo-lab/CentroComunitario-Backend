package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import centrocomunitario.Model.AnunciosModel;
import centrocomunitario.Repository.IAnunciosRepository;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class AnunciosServiceImp implements IAnunciosService {
    @Autowired IAnunciosRepository anunciosRepository;
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public AnunciosModel crearAnuncio(AnunciosModel anuncio) {
        if (anuncio.getAutor_id() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "autor_id es requerido");
        }
        if (!usuariosRepository.existsById(anuncio.getAutor_id())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "autor_id del anuncio no existe");
        }
        anuncio.setFecha_publicacion(LocalDate.now());
        anuncio.setVisible(true);
        return anunciosRepository.save(anuncio);
    }

    @Override
    public List<AnunciosModel> listarAnuncios() {
        return anunciosRepository.findAll();
    }

    @Override
    public List<AnunciosModel> buscarVisibles() {
        return anunciosRepository.buscarVisibles();
    }

    @Override
    public List<AnunciosModel> buscarPorAudiencia(String audiencia) {
        return anunciosRepository.buscarPorAudiencia(audiencia);
    }

    @Override
    public List<AnunciosModel> anunciosDeCoordinadores() {
        return anunciosRepository.anunciosDeCoordinadores();
    }
}

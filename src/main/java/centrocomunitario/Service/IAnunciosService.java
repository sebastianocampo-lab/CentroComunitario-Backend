package centrocomunitario.Service;

import java.util.List;
import centrocomunitario.Model.AnunciosModel;

public interface IAnunciosService {
    AnunciosModel crearAnuncio(AnunciosModel anuncio);
    List<AnunciosModel> listarAnuncios();
    List<AnunciosModel> buscarVisibles();
    List<AnunciosModel> buscarPorAudiencia(String audiencia);
}

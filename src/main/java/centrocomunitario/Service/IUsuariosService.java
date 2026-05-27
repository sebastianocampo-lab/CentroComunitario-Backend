package centrocomunitario.Service;

import java.util.List;
import centrocomunitario.Model.UsuariosModel;

public interface IUsuariosService {
    UsuariosModel crearUsuario(UsuariosModel usuario);
    List<UsuariosModel> listarUsuarios();
    List<UsuariosModel> buscarPorRol(String rol);
    List<UsuariosModel> buscarActivos();
}
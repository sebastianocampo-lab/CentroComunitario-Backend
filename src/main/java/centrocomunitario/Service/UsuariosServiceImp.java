package centrocomunitario.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import centrocomunitario.Model.UsuariosModel;
import centrocomunitario.Repository.IUsuariosRepository;

@Service
public class UsuariosServiceImp implements IUsuariosService {
    @Autowired IUsuariosRepository usuariosRepository;

    @Override
    public UsuariosModel crearUsuario(UsuariosModel usuario) {
        usuario.setFecha_registro(LocalDate.now());
        usuario.setActivo(true);
        return usuariosRepository.save(usuario);
    }

    @Override
    public List<UsuariosModel> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public List<UsuariosModel> buscarPorRol(String rol) {
        return usuariosRepository.buscarPorRol(rol);
    }

    @Override
    public List<UsuariosModel> buscarActivos() {
        return usuariosRepository.buscarActivos();
    }

    @Override
    public UsuariosModel buscarPorCorreo(String correo) {
        return usuariosRepository.buscarPorCorreo(correo);
    }

    @Override
    public List<UsuariosModel> buscarPorNombre(String nombre) {
        return usuariosRepository.buscarPorNombre(nombre);
    }

    @Override
    public List<UsuariosModel> buscarPorEdadMinima(int edad) {
        return usuariosRepository.buscarPorEdadMinima(edad);
    }
}
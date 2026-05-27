package centrocomunitario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import centrocomunitario.Model.UsuariosModel;
import centrocomunitario.Service.IUsuariosService;

@RestController
@RequestMapping("/UAO/apirest/usuarios")
public class UsuariosController {
    @Autowired IUsuariosService usuariosService;

    @PostMapping("/")
    public ResponseEntity<UsuariosModel> crearUsuario(@RequestBody UsuariosModel usuario) {
        return new ResponseEntity<>(usuariosService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuariosModel>> listarUsuarios() {
        return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
    }
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuariosModel>> buscarPorRol(@PathVariable("rol") String rol) {
        return new ResponseEntity<>(usuariosService.buscarPorRol(rol), HttpStatus.OK);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<UsuariosModel>> buscarActivos() {
        return new ResponseEntity<>(usuariosService.buscarActivos(), HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuariosModel> buscarPorCorreo(@PathVariable("correo") String correo) {
        return new ResponseEntity<>(usuariosService.buscarPorCorreo(correo), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<UsuariosModel>> buscarPorNombre(@PathVariable("nombre") String nombre) {
        return new ResponseEntity<>(usuariosService.buscarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<List<UsuariosModel>> buscarPorEdadMinima(@PathVariable("edad") int edad) {
        return new ResponseEntity<>(usuariosService.buscarPorEdadMinima(edad), HttpStatus.OK);
    }
}

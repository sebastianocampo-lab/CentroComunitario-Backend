package centrocomunitario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
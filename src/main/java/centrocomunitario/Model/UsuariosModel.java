package centrocomunitario.Model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    @Id
    private ObjectId id;
    private String nombre_completo;
    private String documento_identificacion;
    private Integer edad;
    private String correo_electronico;
    private String telefono;
    private String direccion;
    private String rol;
    private String password_hash;
    private LocalDate fecha_registro;
    private Boolean activo;

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
}

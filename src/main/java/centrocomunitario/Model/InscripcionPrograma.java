package centrocomunitario.Model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionPrograma {
    private ObjectId usuario_id;
    private LocalDate fecha_inscripcion;

    @JsonSetter("usuario_id")
    public void setUsuarioIdJson(String id) { this.usuario_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("usuario_id")
    public String getUsuarioIdAsString() { return usuario_id != null ? usuario_id.toHexString() : null; }
}

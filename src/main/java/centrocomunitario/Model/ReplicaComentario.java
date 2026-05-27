package centrocomunitario.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplicaComentario {
    private ObjectId usuario_id;
    private String contenido;
    private LocalDate fecha_publicacion;
    private List<ArchivoAdjuntoForo> archivos_adjuntos = new ArrayList<>();

    @JsonSetter("usuario_id")
    public void setUsuarioIdJson(String id) { this.usuario_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("usuario_id")
    public String getUsuarioIdAsString() { return usuario_id != null ? usuario_id.toHexString() : null; }
}

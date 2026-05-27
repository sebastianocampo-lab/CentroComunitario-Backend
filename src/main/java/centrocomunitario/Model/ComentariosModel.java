package centrocomunitario.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("comentarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentariosModel {
    @Id
    private ObjectId id;
    private ObjectId foro_id;
    private ObjectId usuario_id;
    private String contenido;
    private LocalDate fecha_publicacion;
    private List<ArchivoAdjuntoForo> archivos_adjuntos = new ArrayList<>();
    private List<ReplicaComentario> replicas_comentarios = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() { return id != null ? id.toHexString() : null; }

    @JsonSetter("foro_id")
    public void setForoIdJson(String id) { this.foro_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("foro_id")
    public String getForoIdAsString() { return foro_id != null ? foro_id.toHexString() : null; }

    @JsonSetter("usuario_id")
    public void setUsuarioIdJson(String id) { this.usuario_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("usuario_id")
    public String getUsuarioIdAsString() { return usuario_id != null ? usuario_id.toHexString() : null; }
}

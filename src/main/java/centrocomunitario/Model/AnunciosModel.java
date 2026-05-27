package centrocomunitario.Model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("anuncios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnunciosModel {
    @Id
    private ObjectId id;
    private String titulo;
    private String contenido;
    private ObjectId autor_id;
    private LocalDate fecha_publicacion;
    private ObjectId actividad_id;
    private ObjectId programa_id;
    private String dirigido_a;
    private Boolean visible;

    @JsonProperty("id")
    public String getIdAsString() { return id != null ? id.toHexString() : null; }

    @JsonSetter("autor_id")
    public void setAutorIdJson(String id) { this.autor_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("autor_id")
    public String getAutorIdAsString() { return autor_id != null ? autor_id.toHexString() : null; }

    @JsonSetter("actividad_id")
    public void setActividadIdJson(String id) { this.actividad_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("actividad_id")
    public String getActividadIdAsString() { return actividad_id != null ? actividad_id.toHexString() : null; }

    @JsonSetter("programa_id")
    public void setProgramaIdJson(String id) { this.programa_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("programa_id")
    public String getProgramaIdAsString() { return programa_id != null ? programa_id.toHexString() : null; }
}

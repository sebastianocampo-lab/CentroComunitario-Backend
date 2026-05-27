package centrocomunitario.Model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadRef {
    private ObjectId actividad_id;

    @JsonSetter("actividad_id")
    public void setActividadIdJson(String id) { this.actividad_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("actividad_id")
    public String getActividadIdAsString() { return actividad_id != null ? actividad_id.toHexString() : null; }
}

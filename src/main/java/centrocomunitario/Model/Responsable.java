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
public class Responsable {
    private ObjectId responsable_id;

    @JsonSetter("responsable_id")
    public void setResponsableIdJson(String id) { this.responsable_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("responsable_id")
    public String getResponsableIdAsString() { return responsable_id != null ? responsable_id.toHexString() : null; }
}

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
public class ParticipanteConvocado {
    private ObjectId participante_id;

    @JsonSetter("participante_id")
    public void setParticipanteIdJson(String id) { this.participante_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("participante_id")
    public String getParticipanteIdAsString() { return participante_id != null ? participante_id.toHexString() : null; }
}

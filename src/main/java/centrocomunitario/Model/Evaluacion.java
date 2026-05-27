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
public class Evaluacion {
    private ObjectId sesion_id;
    private ObjectId participante_id;
    private Integer valoracion_numerica;
    private String observaciones;
    private String sugerencias_mejora;
    private LocalDate fecha;

    @JsonSetter("sesion_id")
    public void setSesionIdJson(String id) { this.sesion_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("sesion_id")
    public String getSesionIdAsString() { return sesion_id != null ? sesion_id.toHexString() : null; }

    @JsonSetter("participante_id")
    public void setParticipanteIdJson(String id) { this.participante_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("participante_id")
    public String getParticipanteIdAsString() { return participante_id != null ? participante_id.toHexString() : null; }
}

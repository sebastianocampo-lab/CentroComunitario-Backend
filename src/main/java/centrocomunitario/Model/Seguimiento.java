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
public class Seguimiento {
    private ObjectId instructor_id;
    private ObjectId participante_id;
    private String desempeno;
    private String compromiso;
    private Integer nivel_progreso;
    private String comentarios;
    private List<AspectoEvaluado> aspectos_evaluados = new ArrayList<>();
    private LocalDate fecha;

    @JsonSetter("instructor_id")
    public void setInstructorIdJson(String id) { this.instructor_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("instructor_id")
    public String getInstructorIdAsString() { return instructor_id != null ? instructor_id.toHexString() : null; }

    @JsonSetter("participante_id")
    public void setParticipanteIdJson(String id) { this.participante_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("participante_id")
    public String getParticipanteIdAsString() { return participante_id != null ? participante_id.toHexString() : null; }
}

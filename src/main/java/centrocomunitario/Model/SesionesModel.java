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

@Document("sesiones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SesionesModel {
    @Id
    private ObjectId id;
    private ObjectId actividad_id;
    private LocalDate fecha;
    private String hora_inicio;
    private String hora_finalizacion;
    private String modalidad;
    private ObjectId espacio_id;
    private String enlace_acceso;
    private List<ParticipanteConvocado> participantes_convocados = new ArrayList<>();
    private List<Asistencia> asistencia = new ArrayList<>();
    private List<ArchivoAdjunto> archivos_adjuntos = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() { return id != null ? id.toHexString() : null; }

    @JsonSetter("actividad_id")
    public void setActividadIdJson(String id) { this.actividad_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("actividad_id")
    public String getActividadIdAsString() { return actividad_id != null ? actividad_id.toHexString() : null; }

    @JsonSetter("espacio_id")
    public void setEspacioIdJson(String id) { this.espacio_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("espacio_id")
    public String getEspacioIdAsString() { return espacio_id != null ? espacio_id.toHexString() : null; }
}

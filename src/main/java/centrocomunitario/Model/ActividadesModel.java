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

@Document("actividades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadesModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String objetivo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_finalizacion;
    private Integer intensidad_horaria;
    private Integer cupo_maximo;
    private String estado;
    private List<Recurso> recursos_requeridos = new ArrayList<>();
    private Boolean aprobado;
    private ObjectId instructor_id;
    private ObjectId propuesto_por;
    private LocalDate fecha_propuesta;
    private ObjectId aprobado_por;
    private LocalDate fecha_aprobacion;
    private ObjectId programa_id;
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private List<Evaluacion> evaluaciones = new ArrayList<>();
    private List<Seguimiento> seguimientos = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() { return id != null ? id.toHexString() : null; }

    @JsonSetter("instructor_id")
    public void setInstructorIdJson(String id) { this.instructor_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("instructor_id")
    public String getInstructorIdAsString() { return instructor_id != null ? instructor_id.toHexString() : null; }

    @JsonSetter("propuesto_por")
    public void setPropuestoPorJson(String id) { this.propuesto_por = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("propuesto_por")
    public String getPropuestoPorAsString() { return propuesto_por != null ? propuesto_por.toHexString() : null; }

    @JsonSetter("aprobado_por")
    public void setAprobadoPorJson(String id) { this.aprobado_por = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("aprobado_por")
    public String getAprobadoPorAsString() { return aprobado_por != null ? aprobado_por.toHexString() : null; }

    @JsonSetter("programa_id")
    public void setProgramaIdJson(String id) { this.programa_id = (id == null) ? null : new ObjectId(id); }
    @JsonProperty("programa_id")
    public String getProgramaIdAsString() { return programa_id != null ? programa_id.toHexString() : null; }
}

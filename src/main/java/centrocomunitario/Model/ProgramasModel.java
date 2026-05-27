package centrocomunitario.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("programas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramasModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String poblacion_objetivo;
    private String estado;
    private List<Responsable> responsables = new ArrayList<>();
    private List<ActividadRef> actividades = new ArrayList<>();
    private List<InscripcionPrograma> inscripciones_programa = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
}

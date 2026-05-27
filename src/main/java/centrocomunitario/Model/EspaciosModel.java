package centrocomunitario.Model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("espacios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspaciosModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String tipo;
    private Integer capacidad;
    private String ubicacion;
    private Boolean disponible;
    private List<Recurso> recursos = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
}

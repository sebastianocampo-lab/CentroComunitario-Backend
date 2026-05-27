package centrocomunitario.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recurso {
    private String nombre;
    private String tipo;
    private Integer cantidad;
}

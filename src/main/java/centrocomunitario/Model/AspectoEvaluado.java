package centrocomunitario.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AspectoEvaluado {
    private String nombre;
    private Integer valoracion;
}

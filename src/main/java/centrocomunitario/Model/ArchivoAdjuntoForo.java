package centrocomunitario.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivoAdjuntoForo {
    private String nombre;
    private String tipo;
    private String url;
    private String descripcion;
}

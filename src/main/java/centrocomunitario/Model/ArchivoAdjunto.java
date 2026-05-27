package centrocomunitario.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivoAdjunto {
    private String nombre;
    private String tipo;
    private String url;
    private LocalDate fecha_subida;
}

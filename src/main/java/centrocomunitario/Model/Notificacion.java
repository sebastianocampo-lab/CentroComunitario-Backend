package centrocomunitario.Model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {
    private String mensaje;
    private LocalDate fecha;
    private Boolean leida;
}

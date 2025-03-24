package microservicio.app_terminal.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
public class Departamento {

   private Long id;
   private String nombre;
   private boolean activo;
   
}

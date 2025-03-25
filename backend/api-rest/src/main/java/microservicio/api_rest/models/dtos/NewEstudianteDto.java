package microservicio.api_rest.models.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewEstudianteDto {

   private String nombre;
   private String email;
   private LocalDate fechaNacimiento;

}

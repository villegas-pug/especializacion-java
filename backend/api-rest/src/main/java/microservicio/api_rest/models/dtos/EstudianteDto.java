package microservicio.api_rest.models.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservicio.api_rest.models.entities.Matricula;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {

   private Long id;
   List<Matricula> matriculas;
   private String nombre;
   private String email;
   private LocalDate fechaNacimiento;

}

package microservicio.api_rest.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Matriculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
public class Matricula {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idEstudiante", nullable = false)
   private Estudiante estudiante;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idCurso", nullable = false)
   private Curso curso;

   private String calificacion;

}